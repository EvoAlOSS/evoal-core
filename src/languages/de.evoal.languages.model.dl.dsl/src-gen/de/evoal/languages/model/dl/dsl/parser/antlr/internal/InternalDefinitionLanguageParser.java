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

@SuppressWarnings("all")
public class InternalDefinitionLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_DOUBLE", "RULE_INT", "RULE_STRING", "RULE_QUOTED_ID", "RULE_ID", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'module'", "'{'", "'}'", "'import'", "';'", "'OR'", "'XOR'", "'AND'", "'!'", "'^'", "'('", "')'", "','", "'true'", "'false'", "'abstract'", "'type'", "'extends'", "':'", "':='", "'literal'", "'instance'", "'|'", "'string'", "'expression'", "'int'", "'float'", "'boolean'", "'void'", "'data'", "'array'", "'def'", "'const'", "'.'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'"
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


        public InternalDefinitionLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDefinitionLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDefinitionLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDefinitionLanguage.g"; }



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
    // InternalDefinitionLanguage.g:66:1: entryRuleDefinitionModelRule returns [EObject current=null] : iv_ruleDefinitionModelRule= ruleDefinitionModelRule EOF ;
    public final EObject entryRuleDefinitionModelRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinitionModelRule = null;


        try {
            // InternalDefinitionLanguage.g:66:60: (iv_ruleDefinitionModelRule= ruleDefinitionModelRule EOF )
            // InternalDefinitionLanguage.g:67:2: iv_ruleDefinitionModelRule= ruleDefinitionModelRule EOF
            {
             newCompositeNode(grammarAccess.getDefinitionModelRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefinitionModelRule=ruleDefinitionModelRule();

            state._fsp--;

             current =iv_ruleDefinitionModelRule; 
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
    // $ANTLR end "entryRuleDefinitionModelRule"


    // $ANTLR start "ruleDefinitionModelRule"
    // InternalDefinitionLanguage.g:73:1: ruleDefinitionModelRule returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_types_4_0= ruleTypeDefinitionRule ) ) | ( (lv_functions_5_0= ruleFunctionDefinitionRule ) ) | ( (lv_constants_6_0= ruleConstantDefinitionRule ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleDefinitionModelRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        EObject lv_imports_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_types_4_0 = null;

        EObject lv_functions_5_0 = null;

        EObject lv_constants_6_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:79:2: ( ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_types_4_0= ruleTypeDefinitionRule ) ) | ( (lv_functions_5_0= ruleFunctionDefinitionRule ) ) | ( (lv_constants_6_0= ruleConstantDefinitionRule ) ) )* otherlv_7= '}' ) )
            // InternalDefinitionLanguage.g:80:2: ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_types_4_0= ruleTypeDefinitionRule ) ) | ( (lv_functions_5_0= ruleFunctionDefinitionRule ) ) | ( (lv_constants_6_0= ruleConstantDefinitionRule ) ) )* otherlv_7= '}' )
            {
            // InternalDefinitionLanguage.g:80:2: ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_types_4_0= ruleTypeDefinitionRule ) ) | ( (lv_functions_5_0= ruleFunctionDefinitionRule ) ) | ( (lv_constants_6_0= ruleConstantDefinitionRule ) ) )* otherlv_7= '}' )
            // InternalDefinitionLanguage.g:81:3: ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_types_4_0= ruleTypeDefinitionRule ) ) | ( (lv_functions_5_0= ruleFunctionDefinitionRule ) ) | ( (lv_constants_6_0= ruleConstantDefinitionRule ) ) )* otherlv_7= '}'
            {
            // InternalDefinitionLanguage.g:81:3: ( (lv_imports_0_0= ruleImportRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==18) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:82:4: (lv_imports_0_0= ruleImportRule )
            	    {
            	    // InternalDefinitionLanguage.g:82:4: (lv_imports_0_0= ruleImportRule )
            	    // InternalDefinitionLanguage.g:83:5: lv_imports_0_0= ruleImportRule
            	    {

            	    					newCompositeNode(grammarAccess.getDefinitionModelRuleAccess().getImportsImportRuleParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImportRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDefinitionModelRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_0_0,
            	    						"de.evoal.languages.model.dl.dsl.DefinitionLanguage.ImportRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_1=(Token)match(input,15,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getDefinitionModelRuleAccess().getModuleKeyword_1());
            		
            // InternalDefinitionLanguage.g:104:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:105:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:105:4: (lv_name_2_0= ruleQualifiedName )
            // InternalDefinitionLanguage.g:106:5: lv_name_2_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getDefinitionModelRuleAccess().getNameQualifiedNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


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

            otherlv_3=(Token)match(input,16,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getDefinitionModelRuleAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalDefinitionLanguage.g:127:3: ( ( (lv_types_4_0= ruleTypeDefinitionRule ) ) | ( (lv_functions_5_0= ruleFunctionDefinitionRule ) ) | ( (lv_constants_6_0= ruleConstantDefinitionRule ) ) )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case 30:
                case 31:
                    {
                    alt2=1;
                    }
                    break;
                case 46:
                    {
                    alt2=2;
                    }
                    break;
                case 47:
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:128:4: ( (lv_types_4_0= ruleTypeDefinitionRule ) )
            	    {
            	    // InternalDefinitionLanguage.g:128:4: ( (lv_types_4_0= ruleTypeDefinitionRule ) )
            	    // InternalDefinitionLanguage.g:129:5: (lv_types_4_0= ruleTypeDefinitionRule )
            	    {
            	    // InternalDefinitionLanguage.g:129:5: (lv_types_4_0= ruleTypeDefinitionRule )
            	    // InternalDefinitionLanguage.g:130:6: lv_types_4_0= ruleTypeDefinitionRule
            	    {

            	    						newCompositeNode(grammarAccess.getDefinitionModelRuleAccess().getTypesTypeDefinitionRuleParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_types_4_0=ruleTypeDefinitionRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDefinitionModelRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"types",
            	    							lv_types_4_0,
            	    							"de.evoal.languages.model.base.dsl.BaseLanguage.TypeDefinitionRule");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalDefinitionLanguage.g:148:4: ( (lv_functions_5_0= ruleFunctionDefinitionRule ) )
            	    {
            	    // InternalDefinitionLanguage.g:148:4: ( (lv_functions_5_0= ruleFunctionDefinitionRule ) )
            	    // InternalDefinitionLanguage.g:149:5: (lv_functions_5_0= ruleFunctionDefinitionRule )
            	    {
            	    // InternalDefinitionLanguage.g:149:5: (lv_functions_5_0= ruleFunctionDefinitionRule )
            	    // InternalDefinitionLanguage.g:150:6: lv_functions_5_0= ruleFunctionDefinitionRule
            	    {

            	    						newCompositeNode(grammarAccess.getDefinitionModelRuleAccess().getFunctionsFunctionDefinitionRuleParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_functions_5_0=ruleFunctionDefinitionRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDefinitionModelRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"functions",
            	    							lv_functions_5_0,
            	    							"de.evoal.languages.model.base.dsl.BaseLanguage.FunctionDefinitionRule");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalDefinitionLanguage.g:168:4: ( (lv_constants_6_0= ruleConstantDefinitionRule ) )
            	    {
            	    // InternalDefinitionLanguage.g:168:4: ( (lv_constants_6_0= ruleConstantDefinitionRule ) )
            	    // InternalDefinitionLanguage.g:169:5: (lv_constants_6_0= ruleConstantDefinitionRule )
            	    {
            	    // InternalDefinitionLanguage.g:169:5: (lv_constants_6_0= ruleConstantDefinitionRule )
            	    // InternalDefinitionLanguage.g:170:6: lv_constants_6_0= ruleConstantDefinitionRule
            	    {

            	    						newCompositeNode(grammarAccess.getDefinitionModelRuleAccess().getConstantsConstantDefinitionRuleParserRuleCall_4_2_0());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_constants_6_0=ruleConstantDefinitionRule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDefinitionModelRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"constants",
            	    							lv_constants_6_0,
            	    							"de.evoal.languages.model.base.dsl.BaseLanguage.ConstantDefinitionRule");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getDefinitionModelRuleAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleDefinitionModelRule"


    // $ANTLR start "entryRuleImportRule"
    // InternalDefinitionLanguage.g:196:1: entryRuleImportRule returns [EObject current=null] : iv_ruleImportRule= ruleImportRule EOF ;
    public final EObject entryRuleImportRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportRule = null;


        try {
            // InternalDefinitionLanguage.g:196:51: (iv_ruleImportRule= ruleImportRule EOF )
            // InternalDefinitionLanguage.g:197:2: iv_ruleImportRule= ruleImportRule EOF
            {
             newCompositeNode(grammarAccess.getImportRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImportRule=ruleImportRule();

            state._fsp--;

             current =iv_ruleImportRule; 
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
    // $ANTLR end "entryRuleImportRule"


    // $ANTLR start "ruleImportRule"
    // InternalDefinitionLanguage.g:203:1: ruleImportRule returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) otherlv_2= ';' ) ;
    public final EObject ruleImportRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:209:2: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) otherlv_2= ';' ) )
            // InternalDefinitionLanguage.g:210:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) otherlv_2= ';' )
            {
            // InternalDefinitionLanguage.g:210:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) otherlv_2= ';' )
            // InternalDefinitionLanguage.g:211:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getImportRuleAccess().getImportKeyword_0());
            		
            // InternalDefinitionLanguage.g:215:3: ( (lv_importedNamespace_1_0= ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:216:4: (lv_importedNamespace_1_0= ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:216:4: (lv_importedNamespace_1_0= ruleQualifiedName )
            // InternalDefinitionLanguage.g:217:5: lv_importedNamespace_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getImportRuleAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_7);
            lv_importedNamespace_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImportRuleRule());
            					}
            					set(
            						current,
            						"importedNamespace",
            						lv_importedNamespace_1_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getImportRuleAccess().getSemicolonKeyword_2());
            		

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
    // $ANTLR end "ruleImportRule"


    // $ANTLR start "entryRuleExpressionRule"
    // InternalDefinitionLanguage.g:242:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:242:55: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // InternalDefinitionLanguage.g:243:2: iv_ruleExpressionRule= ruleExpressionRule EOF
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
    // InternalDefinitionLanguage.g:249:1: ruleExpressionRule returns [EObject current=null] : this_OrExpressionRule_0= ruleOrExpressionRule ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:255:2: (this_OrExpressionRule_0= ruleOrExpressionRule )
            // InternalDefinitionLanguage.g:256:2: this_OrExpressionRule_0= ruleOrExpressionRule
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
    // InternalDefinitionLanguage.g:267:1: entryRuleOrExpressionRule returns [EObject current=null] : iv_ruleOrExpressionRule= ruleOrExpressionRule EOF ;
    public final EObject entryRuleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:267:57: (iv_ruleOrExpressionRule= ruleOrExpressionRule EOF )
            // InternalDefinitionLanguage.g:268:2: iv_ruleOrExpressionRule= ruleOrExpressionRule EOF
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
    // InternalDefinitionLanguage.g:274:1: ruleOrExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) ;
    public final EObject ruleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:280:2: ( ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) )
            // InternalDefinitionLanguage.g:281:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            {
            // InternalDefinitionLanguage.g:281:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            // InternalDefinitionLanguage.g:282:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            {
            // InternalDefinitionLanguage.g:282:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) )
            // InternalDefinitionLanguage.g:283:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            {
            // InternalDefinitionLanguage.g:283:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            // InternalDefinitionLanguage.g:284:5: lv_subExpressions_0_0= ruleXorExpressionRule
            {

            					newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_8);
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

            // InternalDefinitionLanguage.g:301:3: (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==20) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:302:4: otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,20,FOLLOW_9); 

            	    				newLeafNode(otherlv_1, grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0());
            	    			
            	    // InternalDefinitionLanguage.g:306:4: ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    // InternalDefinitionLanguage.g:307:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    {
            	    // InternalDefinitionLanguage.g:307:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    // InternalDefinitionLanguage.g:308:6: lv_subExpressions_2_0= ruleXorExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_8);
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
    // $ANTLR end "ruleOrExpressionRule"


    // $ANTLR start "entryRuleXorExpressionRule"
    // InternalDefinitionLanguage.g:330:1: entryRuleXorExpressionRule returns [EObject current=null] : iv_ruleXorExpressionRule= ruleXorExpressionRule EOF ;
    public final EObject entryRuleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:330:58: (iv_ruleXorExpressionRule= ruleXorExpressionRule EOF )
            // InternalDefinitionLanguage.g:331:2: iv_ruleXorExpressionRule= ruleXorExpressionRule EOF
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
    // InternalDefinitionLanguage.g:337:1: ruleXorExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) ;
    public final EObject ruleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:343:2: ( ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) )
            // InternalDefinitionLanguage.g:344:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            {
            // InternalDefinitionLanguage.g:344:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            // InternalDefinitionLanguage.g:345:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            {
            // InternalDefinitionLanguage.g:345:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) )
            // InternalDefinitionLanguage.g:346:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            {
            // InternalDefinitionLanguage.g:346:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            // InternalDefinitionLanguage.g:347:5: lv_subExpressions_0_0= ruleAndExpressionRule
            {

            					newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_10);
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

            // InternalDefinitionLanguage.g:364:3: (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==21) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:365:4: otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,21,FOLLOW_9); 

            	    				newLeafNode(otherlv_1, grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0());
            	    			
            	    // InternalDefinitionLanguage.g:369:4: ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    // InternalDefinitionLanguage.g:370:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    {
            	    // InternalDefinitionLanguage.g:370:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    // InternalDefinitionLanguage.g:371:6: lv_subExpressions_2_0= ruleAndExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_10);
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
            	    break loop4;
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
    // InternalDefinitionLanguage.g:393:1: entryRuleAndExpressionRule returns [EObject current=null] : iv_ruleAndExpressionRule= ruleAndExpressionRule EOF ;
    public final EObject entryRuleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:393:58: (iv_ruleAndExpressionRule= ruleAndExpressionRule EOF )
            // InternalDefinitionLanguage.g:394:2: iv_ruleAndExpressionRule= ruleAndExpressionRule EOF
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
    // InternalDefinitionLanguage.g:400:1: ruleAndExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) ;
    public final EObject ruleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:406:2: ( ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) )
            // InternalDefinitionLanguage.g:407:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            {
            // InternalDefinitionLanguage.g:407:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            // InternalDefinitionLanguage.g:408:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            {
            // InternalDefinitionLanguage.g:408:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) )
            // InternalDefinitionLanguage.g:409:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            {
            // InternalDefinitionLanguage.g:409:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            // InternalDefinitionLanguage.g:410:5: lv_subExpressions_0_0= ruleNotExpressionRule
            {

            					newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_11);
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

            // InternalDefinitionLanguage.g:427:3: (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==22) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:428:4: otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,22,FOLLOW_9); 

            	    				newLeafNode(otherlv_1, grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0());
            	    			
            	    // InternalDefinitionLanguage.g:432:4: ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    // InternalDefinitionLanguage.g:433:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    {
            	    // InternalDefinitionLanguage.g:433:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    // InternalDefinitionLanguage.g:434:6: lv_subExpressions_2_0= ruleNotExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
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
    // $ANTLR end "ruleAndExpressionRule"


    // $ANTLR start "entryRuleNotExpressionRule"
    // InternalDefinitionLanguage.g:456:1: entryRuleNotExpressionRule returns [EObject current=null] : iv_ruleNotExpressionRule= ruleNotExpressionRule EOF ;
    public final EObject entryRuleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:456:58: (iv_ruleNotExpressionRule= ruleNotExpressionRule EOF )
            // InternalDefinitionLanguage.g:457:2: iv_ruleNotExpressionRule= ruleNotExpressionRule EOF
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
    // InternalDefinitionLanguage.g:463:1: ruleNotExpressionRule returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) ;
    public final EObject ruleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:469:2: ( ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) )
            // InternalDefinitionLanguage.g:470:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            {
            // InternalDefinitionLanguage.g:470:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            // InternalDefinitionLanguage.g:471:3: ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            {
            // InternalDefinitionLanguage.g:471:3: ( (lv_negated_0_0= '!' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==23) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalDefinitionLanguage.g:472:4: (lv_negated_0_0= '!' )
                    {
                    // InternalDefinitionLanguage.g:472:4: (lv_negated_0_0= '!' )
                    // InternalDefinitionLanguage.g:473:5: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,23,FOLLOW_9); 

                    					newLeafNode(lv_negated_0_0, grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getNotExpressionRuleRule());
                    					}
                    					setWithLastConsumed(current, "negated", lv_negated_0_0 != null, "!");
                    				

                    }


                    }
                    break;

            }

            // InternalDefinitionLanguage.g:485:3: ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            // InternalDefinitionLanguage.g:486:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            {
            // InternalDefinitionLanguage.g:486:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            // InternalDefinitionLanguage.g:487:5: lv_operand_1_0= ruleComparisonExpressionRule
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
    // InternalDefinitionLanguage.g:508:1: entryRuleComparisonExpressionRule returns [EObject current=null] : iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF ;
    public final EObject entryRuleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:508:65: (iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF )
            // InternalDefinitionLanguage.g:509:2: iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF
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
    // InternalDefinitionLanguage.g:515:1: ruleComparisonExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) ;
    public final EObject ruleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        EObject lv_comparison_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:521:2: ( ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) )
            // InternalDefinitionLanguage.g:522:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            {
            // InternalDefinitionLanguage.g:522:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            // InternalDefinitionLanguage.g:523:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            {
            // InternalDefinitionLanguage.g:523:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:524:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:524:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:525:5: lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule
            {

            					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_12);
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

            // InternalDefinitionLanguage.g:542:3: ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=49 && LA7_0<=54)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:543:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    {
            	    // InternalDefinitionLanguage.g:543:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    // InternalDefinitionLanguage.g:544:5: lv_comparison_1_0= rulePartialComparisonExpressionRule
            	    {

            	    					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_12);
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
    // $ANTLR end "ruleComparisonExpressionRule"


    // $ANTLR start "entryRulePartialComparisonExpressionRule"
    // InternalDefinitionLanguage.g:565:1: entryRulePartialComparisonExpressionRule returns [EObject current=null] : iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF ;
    public final EObject entryRulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialComparisonExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:565:72: (iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF )
            // InternalDefinitionLanguage.g:566:2: iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF
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
    // InternalDefinitionLanguage.g:572:1: rulePartialComparisonExpressionRule returns [EObject current=null] : ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) ;
    public final EObject rulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:578:2: ( ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) )
            // InternalDefinitionLanguage.g:579:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            {
            // InternalDefinitionLanguage.g:579:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            // InternalDefinitionLanguage.g:580:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            {
            // InternalDefinitionLanguage.g:580:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) )
            // InternalDefinitionLanguage.g:581:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            {
            // InternalDefinitionLanguage.g:581:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            // InternalDefinitionLanguage.g:582:5: lv_operator_0_0= ruleComparisonOperatorRule
            {

            					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_9);
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

            // InternalDefinitionLanguage.g:599:3: ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:600:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:600:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:601:5: lv_subExpression_1_0= ruleAddOrSubtractExpressionRule
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
    // InternalDefinitionLanguage.g:622:1: entryRuleAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOrSubtractExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:622:68: (iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF )
            // InternalDefinitionLanguage.g:623:2: iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF
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
    // InternalDefinitionLanguage.g:629:1: ruleAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) ;
    public final EObject ruleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:635:2: ( ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) )
            // InternalDefinitionLanguage.g:636:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            {
            // InternalDefinitionLanguage.g:636:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            // InternalDefinitionLanguage.g:637:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            {
            // InternalDefinitionLanguage.g:637:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDefinitionLanguage.g:638:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDefinitionLanguage.g:638:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            // InternalDefinitionLanguage.g:639:5: lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule
            {

            					newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_13);
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

            // InternalDefinitionLanguage.g:656:3: ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=55 && LA8_0<=56)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:657:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    {
            	    // InternalDefinitionLanguage.g:657:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) )
            	    // InternalDefinitionLanguage.g:658:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalDefinitionLanguage.g:658:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    // InternalDefinitionLanguage.g:659:6: lv_operators_1_0= ruleAddOrSubtractOperatorRule
            	    {

            	    						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_9);
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

            	    // InternalDefinitionLanguage.g:676:4: ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    // InternalDefinitionLanguage.g:677:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    {
            	    // InternalDefinitionLanguage.g:677:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    // InternalDefinitionLanguage.g:678:6: lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_13);
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
    // $ANTLR end "ruleAddOrSubtractExpressionRule"


    // $ANTLR start "entryRuleMultiplyDivideModuloExpressionRule"
    // InternalDefinitionLanguage.g:700:1: entryRuleMultiplyDivideModuloExpressionRule returns [EObject current=null] : iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF ;
    public final EObject entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideModuloExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:700:75: (iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalDefinitionLanguage.g:701:2: iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalDefinitionLanguage.g:707:1: ruleMultiplyDivideModuloExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) ;
    public final EObject ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:713:2: ( ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) )
            // InternalDefinitionLanguage.g:714:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            {
            // InternalDefinitionLanguage.g:714:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            // InternalDefinitionLanguage.g:715:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            {
            // InternalDefinitionLanguage.g:715:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) )
            // InternalDefinitionLanguage.g:716:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            {
            // InternalDefinitionLanguage.g:716:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            // InternalDefinitionLanguage.g:717:5: lv_leftOperand_0_0= rulePowerOfExpressionRule
            {

            					newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_14);
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

            // InternalDefinitionLanguage.g:734:3: ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=57 && LA9_0<=59)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:735:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    {
            	    // InternalDefinitionLanguage.g:735:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) )
            	    // InternalDefinitionLanguage.g:736:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    {
            	    // InternalDefinitionLanguage.g:736:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    // InternalDefinitionLanguage.g:737:6: lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_9);
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

            	    // InternalDefinitionLanguage.g:754:4: ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    // InternalDefinitionLanguage.g:755:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    {
            	    // InternalDefinitionLanguage.g:755:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    // InternalDefinitionLanguage.g:756:6: lv_operands_2_0= rulePowerOfExpressionRule
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_14);
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
            	    break loop9;
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
    // InternalDefinitionLanguage.g:778:1: entryRulePowerOfExpressionRule returns [EObject current=null] : iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF ;
    public final EObject entryRulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerOfExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:778:62: (iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF )
            // InternalDefinitionLanguage.g:779:2: iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF
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
    // InternalDefinitionLanguage.g:785:1: rulePowerOfExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) ;
    public final EObject rulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_leftOperand_0_0 = null;

        EObject lv_rightOperand_2_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:791:2: ( ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) )
            // InternalDefinitionLanguage.g:792:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            {
            // InternalDefinitionLanguage.g:792:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            // InternalDefinitionLanguage.g:793:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            {
            // InternalDefinitionLanguage.g:793:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalDefinitionLanguage.g:794:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalDefinitionLanguage.g:794:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            // InternalDefinitionLanguage.g:795:5: lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule
            {

            					newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_15);
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

            // InternalDefinitionLanguage.g:812:3: (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==24) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalDefinitionLanguage.g:813:4: otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_9); 

                    				newLeafNode(otherlv_1, grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0());
                    			
                    // InternalDefinitionLanguage.g:817:4: ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    // InternalDefinitionLanguage.g:818:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    {
                    // InternalDefinitionLanguage.g:818:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    // InternalDefinitionLanguage.g:819:6: lv_rightOperand_2_0= rulePowerOfExpressionRule
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
    // InternalDefinitionLanguage.g:841:1: entryRuleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryAddOrSubtractExpressionRule = null;


        try {
            // InternalDefinitionLanguage.g:841:73: (iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalDefinitionLanguage.g:842:2: iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalDefinitionLanguage.g:848:1: ruleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) ) ;
    public final EObject ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operators_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:854:2: ( ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) ) )
            // InternalDefinitionLanguage.g:855:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) )
            {
            // InternalDefinitionLanguage.g:855:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) )
            // InternalDefinitionLanguage.g:856:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) )
            {
            // InternalDefinitionLanguage.g:856:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=55 && LA11_0<=56)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:857:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalDefinitionLanguage.g:857:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    // InternalDefinitionLanguage.g:858:5: lv_operators_0_0= ruleAddOrSubtractOperatorRule
            	    {

            	    					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_9);
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
            	    break loop11;
                }
            } while (true);

            // InternalDefinitionLanguage.g:875:3: ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) )
            // InternalDefinitionLanguage.g:876:4: (lv_subExpression_1_0= ruleLiteralOrReferenceRule )
            {
            // InternalDefinitionLanguage.g:876:4: (lv_subExpression_1_0= ruleLiteralOrReferenceRule )
            // InternalDefinitionLanguage.g:877:5: lv_subExpression_1_0= ruleLiteralOrReferenceRule
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
    // InternalDefinitionLanguage.g:898:1: entryRuleLiteralOrReferenceRule returns [EObject current=null] : iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF ;
    public final EObject entryRuleLiteralOrReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralOrReferenceRule = null;


        try {
            // InternalDefinitionLanguage.g:898:63: (iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF )
            // InternalDefinitionLanguage.g:899:2: iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF
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
    // InternalDefinitionLanguage.g:905:1: ruleLiteralOrReferenceRule returns [EObject current=null] : (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule ) ;
    public final EObject ruleLiteralOrReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_CallRule_0 = null;

        EObject this_LiteralRule_1 = null;

        EObject this_ParanthesesRule_2 = null;

        EObject this_ValueReferenceRule_3 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:911:2: ( (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule ) )
            // InternalDefinitionLanguage.g:912:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )
            {
            // InternalDefinitionLanguage.g:912:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )
            int alt12=4;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalDefinitionLanguage.g:913:3: this_CallRule_0= ruleCallRule
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
                    // InternalDefinitionLanguage.g:922:3: this_LiteralRule_1= ruleLiteralRule
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
                    // InternalDefinitionLanguage.g:931:3: this_ParanthesesRule_2= ruleParanthesesRule
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
                    // InternalDefinitionLanguage.g:940:3: this_ValueReferenceRule_3= ruleValueReferenceRule
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
    // InternalDefinitionLanguage.g:952:1: entryRuleParanthesesRule returns [EObject current=null] : iv_ruleParanthesesRule= ruleParanthesesRule EOF ;
    public final EObject entryRuleParanthesesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesesRule = null;


        try {
            // InternalDefinitionLanguage.g:952:56: (iv_ruleParanthesesRule= ruleParanthesesRule EOF )
            // InternalDefinitionLanguage.g:953:2: iv_ruleParanthesesRule= ruleParanthesesRule EOF
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
    // InternalDefinitionLanguage.g:959:1: ruleParanthesesRule returns [EObject current=null] : (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) ;
    public final EObject ruleParanthesesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:965:2: ( (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) )
            // InternalDefinitionLanguage.g:966:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            {
            // InternalDefinitionLanguage.g:966:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            // InternalDefinitionLanguage.g:967:3: otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0());
            		
            // InternalDefinitionLanguage.g:971:3: ( (lv_subExpression_1_0= ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:972:4: (lv_subExpression_1_0= ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:972:4: (lv_subExpression_1_0= ruleExpressionRule )
            // InternalDefinitionLanguage.g:973:5: lv_subExpression_1_0= ruleExpressionRule
            {

            					newCompositeNode(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
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

            otherlv_2=(Token)match(input,26,FOLLOW_2); 

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
    // InternalDefinitionLanguage.g:998:1: entryRuleCallRule returns [EObject current=null] : iv_ruleCallRule= ruleCallRule EOF ;
    public final EObject entryRuleCallRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallRule = null;


        try {
            // InternalDefinitionLanguage.g:998:49: (iv_ruleCallRule= ruleCallRule EOF )
            // InternalDefinitionLanguage.g:999:2: iv_ruleCallRule= ruleCallRule EOF
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
    // InternalDefinitionLanguage.g:1005:1: ruleCallRule returns [EObject current=null] : ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) ;
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
            // InternalDefinitionLanguage.g:1011:2: ( ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) )
            // InternalDefinitionLanguage.g:1012:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            {
            // InternalDefinitionLanguage.g:1012:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            // InternalDefinitionLanguage.g:1013:3: ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')'
            {
            // InternalDefinitionLanguage.g:1013:3: ( (lv_function_0_0= ruleFunctionNameRule ) )
            // InternalDefinitionLanguage.g:1014:4: (lv_function_0_0= ruleFunctionNameRule )
            {
            // InternalDefinitionLanguage.g:1014:4: (lv_function_0_0= ruleFunctionNameRule )
            // InternalDefinitionLanguage.g:1015:5: lv_function_0_0= ruleFunctionNameRule
            {

            					newCompositeNode(grammarAccess.getCallRuleAccess().getFunctionFunctionNameRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_17);
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

            otherlv_1=(Token)match(input,25,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1());
            		
            // InternalDefinitionLanguage.g:1036:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=RULE_DOUBLE && LA14_0<=RULE_ID)||LA14_0==23||LA14_0==25||(LA14_0>=28 && LA14_0<=29)||(LA14_0>=55 && LA14_0<=56)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalDefinitionLanguage.g:1037:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalDefinitionLanguage.g:1037:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalDefinitionLanguage.g:1038:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalDefinitionLanguage.g:1038:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalDefinitionLanguage.g:1039:6: lv_parameters_2_0= ruleExpressionRule
                    {

                    						newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_19);
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

                    // InternalDefinitionLanguage.g:1056:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==27) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalDefinitionLanguage.g:1057:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,27,FOLLOW_9); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalDefinitionLanguage.g:1061:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalDefinitionLanguage.g:1062:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalDefinitionLanguage.g:1062:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalDefinitionLanguage.g:1063:7: lv_parameters_4_0= ruleExpressionRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_19);
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
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,26,FOLLOW_2); 

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
    // InternalDefinitionLanguage.g:1090:1: entryRuleValueReferenceRule returns [EObject current=null] : iv_ruleValueReferenceRule= ruleValueReferenceRule EOF ;
    public final EObject entryRuleValueReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueReferenceRule = null;


        try {
            // InternalDefinitionLanguage.g:1090:59: (iv_ruleValueReferenceRule= ruleValueReferenceRule EOF )
            // InternalDefinitionLanguage.g:1091:2: iv_ruleValueReferenceRule= ruleValueReferenceRule EOF
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
    // InternalDefinitionLanguage.g:1097:1: ruleValueReferenceRule returns [EObject current=null] : this_ConstantReferenceRule_0= ruleConstantReferenceRule ;
    public final EObject ruleValueReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_ConstantReferenceRule_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1103:2: (this_ConstantReferenceRule_0= ruleConstantReferenceRule )
            // InternalDefinitionLanguage.g:1104:2: this_ConstantReferenceRule_0= ruleConstantReferenceRule
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
    // InternalDefinitionLanguage.g:1115:1: entryRuleConstantReferenceRule returns [EObject current=null] : iv_ruleConstantReferenceRule= ruleConstantReferenceRule EOF ;
    public final EObject entryRuleConstantReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantReferenceRule = null;


        try {
            // InternalDefinitionLanguage.g:1115:62: (iv_ruleConstantReferenceRule= ruleConstantReferenceRule EOF )
            // InternalDefinitionLanguage.g:1116:2: iv_ruleConstantReferenceRule= ruleConstantReferenceRule EOF
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
    // InternalDefinitionLanguage.g:1122:1: ruleConstantReferenceRule returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleConstantReferenceRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1128:2: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:1129:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:1129:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:1130:3: ( ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:1130:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:1131:4: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:1148:1: entryRuleLiteralRule returns [EObject current=null] : iv_ruleLiteralRule= ruleLiteralRule EOF ;
    public final EObject entryRuleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRule = null;


        try {
            // InternalDefinitionLanguage.g:1148:52: (iv_ruleLiteralRule= ruleLiteralRule EOF )
            // InternalDefinitionLanguage.g:1149:2: iv_ruleLiteralRule= ruleLiteralRule EOF
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
    // InternalDefinitionLanguage.g:1155:1: ruleLiteralRule returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule ) ;
    public final EObject ruleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_StringLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1161:2: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule ) )
            // InternalDefinitionLanguage.g:1162:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule )
            {
            // InternalDefinitionLanguage.g:1162:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule )
            int alt15=3;
            switch ( input.LA(1) ) {
            case RULE_DOUBLE:
            case RULE_INT:
                {
                alt15=1;
                }
                break;
            case RULE_STRING:
                {
                alt15=2;
                }
                break;
            case 28:
            case 29:
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalDefinitionLanguage.g:1163:3: this_NumberLiteralRule_0= ruleNumberLiteralRule
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
                    // InternalDefinitionLanguage.g:1172:3: this_StringLiteralRule_1= ruleStringLiteralRule
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
                    // InternalDefinitionLanguage.g:1181:3: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
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
    // InternalDefinitionLanguage.g:1193:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // InternalDefinitionLanguage.g:1193:58: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // InternalDefinitionLanguage.g:1194:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
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
    // InternalDefinitionLanguage.g:1200:1: ruleNumberLiteralRule returns [EObject current=null] : (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_DoubleLiteralRule_0 = null;

        EObject this_IntegerLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1206:2: ( (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) )
            // InternalDefinitionLanguage.g:1207:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            {
            // InternalDefinitionLanguage.g:1207:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_DOUBLE) ) {
                alt16=1;
            }
            else if ( (LA16_0==RULE_INT) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalDefinitionLanguage.g:1208:3: this_DoubleLiteralRule_0= ruleDoubleLiteralRule
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
                    // InternalDefinitionLanguage.g:1217:3: this_IntegerLiteralRule_1= ruleIntegerLiteralRule
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
    // InternalDefinitionLanguage.g:1229:1: entryRuleDoubleLiteralRule returns [EObject current=null] : iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF ;
    public final EObject entryRuleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleLiteralRule = null;


        try {
            // InternalDefinitionLanguage.g:1229:58: (iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF )
            // InternalDefinitionLanguage.g:1230:2: iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF
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
    // InternalDefinitionLanguage.g:1236:1: ruleDoubleLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1242:2: ( ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalDefinitionLanguage.g:1243:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalDefinitionLanguage.g:1243:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalDefinitionLanguage.g:1244:3: ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalDefinitionLanguage.g:1244:3: ( (lv_literal_0_0= RULE_DOUBLE ) )
            // InternalDefinitionLanguage.g:1245:4: (lv_literal_0_0= RULE_DOUBLE )
            {
            // InternalDefinitionLanguage.g:1245:4: (lv_literal_0_0= RULE_DOUBLE )
            // InternalDefinitionLanguage.g:1246:5: lv_literal_0_0= RULE_DOUBLE
            {
            lv_literal_0_0=(Token)match(input,RULE_DOUBLE,FOLLOW_20); 

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

            // InternalDefinitionLanguage.g:1262:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=60 && LA17_0<=79)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalDefinitionLanguage.g:1263:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalDefinitionLanguage.g:1263:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalDefinitionLanguage.g:1264:5: lv_factor_1_0= ruleFactorRule
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
    // InternalDefinitionLanguage.g:1285:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // InternalDefinitionLanguage.g:1285:59: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // InternalDefinitionLanguage.g:1286:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
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
    // InternalDefinitionLanguage.g:1292:1: ruleIntegerLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1298:2: ( ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalDefinitionLanguage.g:1299:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalDefinitionLanguage.g:1299:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalDefinitionLanguage.g:1300:3: ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalDefinitionLanguage.g:1300:3: ( (lv_literal_0_0= RULE_INT ) )
            // InternalDefinitionLanguage.g:1301:4: (lv_literal_0_0= RULE_INT )
            {
            // InternalDefinitionLanguage.g:1301:4: (lv_literal_0_0= RULE_INT )
            // InternalDefinitionLanguage.g:1302:5: lv_literal_0_0= RULE_INT
            {
            lv_literal_0_0=(Token)match(input,RULE_INT,FOLLOW_20); 

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

            // InternalDefinitionLanguage.g:1318:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=60 && LA18_0<=79)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalDefinitionLanguage.g:1319:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalDefinitionLanguage.g:1319:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalDefinitionLanguage.g:1320:5: lv_factor_1_0= ruleFactorRule
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
    // InternalDefinitionLanguage.g:1341:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // InternalDefinitionLanguage.g:1341:58: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // InternalDefinitionLanguage.g:1342:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
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
    // InternalDefinitionLanguage.g:1348:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1354:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalDefinitionLanguage.g:1355:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalDefinitionLanguage.g:1355:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalDefinitionLanguage.g:1356:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalDefinitionLanguage.g:1356:3: (lv_value_0_0= RULE_STRING )
            // InternalDefinitionLanguage.g:1357:4: lv_value_0_0= RULE_STRING
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
    // InternalDefinitionLanguage.g:1376:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // InternalDefinitionLanguage.g:1376:59: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // InternalDefinitionLanguage.g:1377:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
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
    // InternalDefinitionLanguage.g:1383:1: ruleBooleanLiteralRule returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1389:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalDefinitionLanguage.g:1390:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalDefinitionLanguage.g:1390:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalDefinitionLanguage.g:1391:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalDefinitionLanguage.g:1391:3: ()
            // InternalDefinitionLanguage.g:1392:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0(),
            					current);
            			

            }

            // InternalDefinitionLanguage.g:1398:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28) ) {
                alt19=1;
            }
            else if ( (LA19_0==29) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalDefinitionLanguage.g:1399:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalDefinitionLanguage.g:1399:4: ( (lv_value_1_0= 'true' ) )
                    // InternalDefinitionLanguage.g:1400:5: (lv_value_1_0= 'true' )
                    {
                    // InternalDefinitionLanguage.g:1400:5: (lv_value_1_0= 'true' )
                    // InternalDefinitionLanguage.g:1401:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,28,FOLLOW_2); 

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
                    // InternalDefinitionLanguage.g:1414:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,29,FOLLOW_2); 

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


    // $ANTLR start "entryRuleTypeDefinitionRule"
    // InternalDefinitionLanguage.g:1423:1: entryRuleTypeDefinitionRule returns [EObject current=null] : iv_ruleTypeDefinitionRule= ruleTypeDefinitionRule EOF ;
    public final EObject entryRuleTypeDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDefinitionRule = null;


        try {
            // InternalDefinitionLanguage.g:1423:59: (iv_ruleTypeDefinitionRule= ruleTypeDefinitionRule EOF )
            // InternalDefinitionLanguage.g:1424:2: iv_ruleTypeDefinitionRule= ruleTypeDefinitionRule EOF
            {
             newCompositeNode(grammarAccess.getTypeDefinitionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypeDefinitionRule=ruleTypeDefinitionRule();

            state._fsp--;

             current =iv_ruleTypeDefinitionRule; 
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
    // $ANTLR end "entryRuleTypeDefinitionRule"


    // $ANTLR start "ruleTypeDefinitionRule"
    // InternalDefinitionLanguage.g:1430:1: ruleTypeDefinitionRule returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'type' ( (lv_name_2_0= ruleStringOrId ) ) (otherlv_3= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_5= '{' ( (lv_attributes_6_0= ruleAttributeDefinitionRule ) )* otherlv_7= '}' ) ;
    public final EObject ruleTypeDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_attributes_6_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1436:2: ( ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'type' ( (lv_name_2_0= ruleStringOrId ) ) (otherlv_3= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_5= '{' ( (lv_attributes_6_0= ruleAttributeDefinitionRule ) )* otherlv_7= '}' ) )
            // InternalDefinitionLanguage.g:1437:2: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'type' ( (lv_name_2_0= ruleStringOrId ) ) (otherlv_3= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_5= '{' ( (lv_attributes_6_0= ruleAttributeDefinitionRule ) )* otherlv_7= '}' )
            {
            // InternalDefinitionLanguage.g:1437:2: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'type' ( (lv_name_2_0= ruleStringOrId ) ) (otherlv_3= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_5= '{' ( (lv_attributes_6_0= ruleAttributeDefinitionRule ) )* otherlv_7= '}' )
            // InternalDefinitionLanguage.g:1438:3: ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'type' ( (lv_name_2_0= ruleStringOrId ) ) (otherlv_3= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_5= '{' ( (lv_attributes_6_0= ruleAttributeDefinitionRule ) )* otherlv_7= '}'
            {
            // InternalDefinitionLanguage.g:1438:3: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==30) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalDefinitionLanguage.g:1439:4: (lv_abstract_0_0= 'abstract' )
                    {
                    // InternalDefinitionLanguage.g:1439:4: (lv_abstract_0_0= 'abstract' )
                    // InternalDefinitionLanguage.g:1440:5: lv_abstract_0_0= 'abstract'
                    {
                    lv_abstract_0_0=(Token)match(input,30,FOLLOW_21); 

                    					newLeafNode(lv_abstract_0_0, grammarAccess.getTypeDefinitionRuleAccess().getAbstractAbstractKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTypeDefinitionRuleRule());
                    					}
                    					setWithLastConsumed(current, "abstract", lv_abstract_0_0 != null, "abstract");
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,31,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getTypeDefinitionRuleAccess().getTypeKeyword_1());
            		
            // InternalDefinitionLanguage.g:1456:3: ( (lv_name_2_0= ruleStringOrId ) )
            // InternalDefinitionLanguage.g:1457:4: (lv_name_2_0= ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:1457:4: (lv_name_2_0= ruleStringOrId )
            // InternalDefinitionLanguage.g:1458:5: lv_name_2_0= ruleStringOrId
            {

            					newCompositeNode(grammarAccess.getTypeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_22);
            lv_name_2_0=ruleStringOrId();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTypeDefinitionRuleRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.StringOrId");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDefinitionLanguage.g:1475:3: (otherlv_3= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==32) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalDefinitionLanguage.g:1476:4: otherlv_3= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_4); 

                    				newLeafNode(otherlv_3, grammarAccess.getTypeDefinitionRuleAccess().getExtendsKeyword_3_0());
                    			
                    // InternalDefinitionLanguage.g:1480:4: ( ( ruleQualifiedName ) )
                    // InternalDefinitionLanguage.g:1481:5: ( ruleQualifiedName )
                    {
                    // InternalDefinitionLanguage.g:1481:5: ( ruleQualifiedName )
                    // InternalDefinitionLanguage.g:1482:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTypeDefinitionRuleRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getTypeDefinitionRuleAccess().getSuperTypeTypeDefinitionCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_5);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,16,FOLLOW_23); 

            			newLeafNode(otherlv_5, grammarAccess.getTypeDefinitionRuleAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalDefinitionLanguage.g:1501:3: ( (lv_attributes_6_0= ruleAttributeDefinitionRule ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=RULE_QUOTED_ID && LA22_0<=RULE_ID)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:1502:4: (lv_attributes_6_0= ruleAttributeDefinitionRule )
            	    {
            	    // InternalDefinitionLanguage.g:1502:4: (lv_attributes_6_0= ruleAttributeDefinitionRule )
            	    // InternalDefinitionLanguage.g:1503:5: lv_attributes_6_0= ruleAttributeDefinitionRule
            	    {

            	    					newCompositeNode(grammarAccess.getTypeDefinitionRuleAccess().getAttributesAttributeDefinitionRuleParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_23);
            	    lv_attributes_6_0=ruleAttributeDefinitionRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTypeDefinitionRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_6_0,
            	    						"de.evoal.languages.model.base.dsl.BaseLanguage.AttributeDefinitionRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getTypeDefinitionRuleAccess().getRightCurlyBracketKeyword_6());
            		

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
    // $ANTLR end "ruleTypeDefinitionRule"


    // $ANTLR start "entryRuleAttributeDefinitionRule"
    // InternalDefinitionLanguage.g:1528:1: entryRuleAttributeDefinitionRule returns [EObject current=null] : iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF ;
    public final EObject entryRuleAttributeDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeDefinitionRule = null;


        try {
            // InternalDefinitionLanguage.g:1528:64: (iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF )
            // InternalDefinitionLanguage.g:1529:2: iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF
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
    // InternalDefinitionLanguage.g:1535:1: ruleAttributeDefinitionRule returns [EObject current=null] : ( ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';' ) ;
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
            // InternalDefinitionLanguage.g:1541:2: ( ( ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';' ) )
            // InternalDefinitionLanguage.g:1542:2: ( ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';' )
            {
            // InternalDefinitionLanguage.g:1542:2: ( ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';' )
            // InternalDefinitionLanguage.g:1543:3: ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';'
            {
            // InternalDefinitionLanguage.g:1543:3: ( (lv_name_0_0= ruleStringOrId ) )
            // InternalDefinitionLanguage.g:1544:4: (lv_name_0_0= ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:1544:4: (lv_name_0_0= ruleStringOrId )
            // InternalDefinitionLanguage.g:1545:5: lv_name_0_0= ruleStringOrId
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

            otherlv_1=(Token)match(input,33,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_1());
            		
            // InternalDefinitionLanguage.g:1566:3: ( (lv_type_2_0= ruleTypeRule ) )
            // InternalDefinitionLanguage.g:1567:4: (lv_type_2_0= ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:1567:4: (lv_type_2_0= ruleTypeRule )
            // InternalDefinitionLanguage.g:1568:5: lv_type_2_0= ruleTypeRule
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

            // InternalDefinitionLanguage.g:1585:3: (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==34) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalDefinitionLanguage.g:1586:4: otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) )
                    {
                    otherlv_3=(Token)match(input,34,FOLLOW_9); 

                    				newLeafNode(otherlv_3, grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_3_0());
                    			
                    // InternalDefinitionLanguage.g:1590:4: ( (lv_initialisation_4_0= ruleExpressionRule ) )
                    // InternalDefinitionLanguage.g:1591:5: (lv_initialisation_4_0= ruleExpressionRule )
                    {
                    // InternalDefinitionLanguage.g:1591:5: (lv_initialisation_4_0= ruleExpressionRule )
                    // InternalDefinitionLanguage.g:1592:6: lv_initialisation_4_0= ruleExpressionRule
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

            otherlv_5=(Token)match(input,19,FOLLOW_2); 

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
    // InternalDefinitionLanguage.g:1618:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
    public final EObject entryRuleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:1618:49: (iv_ruleTypeRule= ruleTypeRule EOF )
            // InternalDefinitionLanguage.g:1619:2: iv_ruleTypeRule= ruleTypeRule EOF
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
    // InternalDefinitionLanguage.g:1625:1: ruleTypeRule returns [EObject current=null] : (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_FloatTypeRule_2= ruleFloatTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule ) ;
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
            // InternalDefinitionLanguage.g:1631:2: ( (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_FloatTypeRule_2= ruleFloatTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule ) )
            // InternalDefinitionLanguage.g:1632:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_FloatTypeRule_2= ruleFloatTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule )
            {
            // InternalDefinitionLanguage.g:1632:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_FloatTypeRule_2= ruleFloatTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule )
            int alt24=10;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt24=1;
                }
                break;
            case 40:
                {
                alt24=2;
                }
                break;
            case 41:
                {
                alt24=3;
                }
                break;
            case 42:
                {
                alt24=4;
                }
                break;
            case 35:
                {
                alt24=5;
                }
                break;
            case 45:
                {
                alt24=6;
                }
                break;
            case 36:
                {
                alt24=7;
                }
                break;
            case 43:
                {
                alt24=8;
                }
                break;
            case 39:
                {
                alt24=9;
                }
                break;
            case 44:
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
                    // InternalDefinitionLanguage.g:1633:3: this_StringTypeRule_0= ruleStringTypeRule
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
                    // InternalDefinitionLanguage.g:1642:3: this_IntTypeRule_1= ruleIntTypeRule
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
                    // InternalDefinitionLanguage.g:1651:3: this_FloatTypeRule_2= ruleFloatTypeRule
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
                    // InternalDefinitionLanguage.g:1660:3: this_BooleanTypeRule_3= ruleBooleanTypeRule
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
                    // InternalDefinitionLanguage.g:1669:3: this_LiteralTypeRule_4= ruleLiteralTypeRule
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
                    // InternalDefinitionLanguage.g:1678:3: this_ArrayTypeRule_5= ruleArrayTypeRule
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
                    // InternalDefinitionLanguage.g:1687:3: this_InstanceTypeRule_6= ruleInstanceTypeRule
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
                    // InternalDefinitionLanguage.g:1696:3: this_VoidTypeRule_7= ruleVoidTypeRule
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
                    // InternalDefinitionLanguage.g:1705:3: this_ExpressionTypeRule_8= ruleExpressionTypeRule
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
                    // InternalDefinitionLanguage.g:1714:3: this_DataTypeRule_9= ruleDataTypeRule
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
    // InternalDefinitionLanguage.g:1726:1: entryRuleLiteralTypeRule returns [EObject current=null] : iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF ;
    public final EObject entryRuleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:1726:56: (iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF )
            // InternalDefinitionLanguage.g:1727:2: iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF
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
    // InternalDefinitionLanguage.g:1733:1: ruleLiteralTypeRule returns [EObject current=null] : ( () otherlv_1= 'literal' ) ;
    public final EObject ruleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1739:2: ( ( () otherlv_1= 'literal' ) )
            // InternalDefinitionLanguage.g:1740:2: ( () otherlv_1= 'literal' )
            {
            // InternalDefinitionLanguage.g:1740:2: ( () otherlv_1= 'literal' )
            // InternalDefinitionLanguage.g:1741:3: () otherlv_1= 'literal'
            {
            // InternalDefinitionLanguage.g:1741:3: ()
            // InternalDefinitionLanguage.g:1742:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,35,FOLLOW_2); 

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
    // InternalDefinitionLanguage.g:1756:1: entryRuleInstanceTypeRule returns [EObject current=null] : iv_ruleInstanceTypeRule= ruleInstanceTypeRule EOF ;
    public final EObject entryRuleInstanceTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:1756:57: (iv_ruleInstanceTypeRule= ruleInstanceTypeRule EOF )
            // InternalDefinitionLanguage.g:1757:2: iv_ruleInstanceTypeRule= ruleInstanceTypeRule EOF
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
    // InternalDefinitionLanguage.g:1763:1: ruleInstanceTypeRule returns [EObject current=null] : ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) (otherlv_3= '|' ( ( ruleQualifiedName ) ) )* ) ;
    public final EObject ruleInstanceTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1769:2: ( ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) (otherlv_3= '|' ( ( ruleQualifiedName ) ) )* ) )
            // InternalDefinitionLanguage.g:1770:2: ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) (otherlv_3= '|' ( ( ruleQualifiedName ) ) )* )
            {
            // InternalDefinitionLanguage.g:1770:2: ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) (otherlv_3= '|' ( ( ruleQualifiedName ) ) )* )
            // InternalDefinitionLanguage.g:1771:3: () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) (otherlv_3= '|' ( ( ruleQualifiedName ) ) )*
            {
            // InternalDefinitionLanguage.g:1771:3: ()
            // InternalDefinitionLanguage.g:1772:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInstanceTypeRuleAccess().getInstanceTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,36,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getInstanceTypeRuleAccess().getInstanceKeyword_1());
            		
            // InternalDefinitionLanguage.g:1782:3: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:1783:4: ( ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:1783:4: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:1784:5: ruleQualifiedName
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

            // InternalDefinitionLanguage.g:1798:3: (otherlv_3= '|' ( ( ruleQualifiedName ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==37) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:1799:4: otherlv_3= '|' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_3=(Token)match(input,37,FOLLOW_4); 

            	    				newLeafNode(otherlv_3, grammarAccess.getInstanceTypeRuleAccess().getVerticalLineKeyword_3_0());
            	    			
            	    // InternalDefinitionLanguage.g:1803:4: ( ( ruleQualifiedName ) )
            	    // InternalDefinitionLanguage.g:1804:5: ( ruleQualifiedName )
            	    {
            	    // InternalDefinitionLanguage.g:1804:5: ( ruleQualifiedName )
            	    // InternalDefinitionLanguage.g:1805:6: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:1824:1: entryRuleStringTypeRule returns [EObject current=null] : iv_ruleStringTypeRule= ruleStringTypeRule EOF ;
    public final EObject entryRuleStringTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:1824:55: (iv_ruleStringTypeRule= ruleStringTypeRule EOF )
            // InternalDefinitionLanguage.g:1825:2: iv_ruleStringTypeRule= ruleStringTypeRule EOF
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
    // InternalDefinitionLanguage.g:1831:1: ruleStringTypeRule returns [EObject current=null] : ( () otherlv_1= 'string' ) ;
    public final EObject ruleStringTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1837:2: ( ( () otherlv_1= 'string' ) )
            // InternalDefinitionLanguage.g:1838:2: ( () otherlv_1= 'string' )
            {
            // InternalDefinitionLanguage.g:1838:2: ( () otherlv_1= 'string' )
            // InternalDefinitionLanguage.g:1839:3: () otherlv_1= 'string'
            {
            // InternalDefinitionLanguage.g:1839:3: ()
            // InternalDefinitionLanguage.g:1840:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,38,FOLLOW_2); 

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
    // InternalDefinitionLanguage.g:1854:1: entryRuleExpressionTypeRule returns [EObject current=null] : iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF ;
    public final EObject entryRuleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:1854:59: (iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF )
            // InternalDefinitionLanguage.g:1855:2: iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF
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
    // InternalDefinitionLanguage.g:1861:1: ruleExpressionTypeRule returns [EObject current=null] : ( () otherlv_1= 'expression' ) ;
    public final EObject ruleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1867:2: ( ( () otherlv_1= 'expression' ) )
            // InternalDefinitionLanguage.g:1868:2: ( () otherlv_1= 'expression' )
            {
            // InternalDefinitionLanguage.g:1868:2: ( () otherlv_1= 'expression' )
            // InternalDefinitionLanguage.g:1869:3: () otherlv_1= 'expression'
            {
            // InternalDefinitionLanguage.g:1869:3: ()
            // InternalDefinitionLanguage.g:1870:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,39,FOLLOW_2); 

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
    // InternalDefinitionLanguage.g:1884:1: entryRuleIntTypeRule returns [EObject current=null] : iv_ruleIntTypeRule= ruleIntTypeRule EOF ;
    public final EObject entryRuleIntTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:1884:52: (iv_ruleIntTypeRule= ruleIntTypeRule EOF )
            // InternalDefinitionLanguage.g:1885:2: iv_ruleIntTypeRule= ruleIntTypeRule EOF
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
    // InternalDefinitionLanguage.g:1891:1: ruleIntTypeRule returns [EObject current=null] : ( () otherlv_1= 'int' ) ;
    public final EObject ruleIntTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1897:2: ( ( () otherlv_1= 'int' ) )
            // InternalDefinitionLanguage.g:1898:2: ( () otherlv_1= 'int' )
            {
            // InternalDefinitionLanguage.g:1898:2: ( () otherlv_1= 'int' )
            // InternalDefinitionLanguage.g:1899:3: () otherlv_1= 'int'
            {
            // InternalDefinitionLanguage.g:1899:3: ()
            // InternalDefinitionLanguage.g:1900:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,40,FOLLOW_2); 

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
    // InternalDefinitionLanguage.g:1914:1: entryRuleFloatTypeRule returns [EObject current=null] : iv_ruleFloatTypeRule= ruleFloatTypeRule EOF ;
    public final EObject entryRuleFloatTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:1914:54: (iv_ruleFloatTypeRule= ruleFloatTypeRule EOF )
            // InternalDefinitionLanguage.g:1915:2: iv_ruleFloatTypeRule= ruleFloatTypeRule EOF
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
    // InternalDefinitionLanguage.g:1921:1: ruleFloatTypeRule returns [EObject current=null] : ( () otherlv_1= 'float' ) ;
    public final EObject ruleFloatTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1927:2: ( ( () otherlv_1= 'float' ) )
            // InternalDefinitionLanguage.g:1928:2: ( () otherlv_1= 'float' )
            {
            // InternalDefinitionLanguage.g:1928:2: ( () otherlv_1= 'float' )
            // InternalDefinitionLanguage.g:1929:3: () otherlv_1= 'float'
            {
            // InternalDefinitionLanguage.g:1929:3: ()
            // InternalDefinitionLanguage.g:1930:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFloatTypeRuleAccess().getFloatTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,41,FOLLOW_2); 

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
    // InternalDefinitionLanguage.g:1944:1: entryRuleBooleanTypeRule returns [EObject current=null] : iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF ;
    public final EObject entryRuleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:1944:56: (iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF )
            // InternalDefinitionLanguage.g:1945:2: iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF
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
    // InternalDefinitionLanguage.g:1951:1: ruleBooleanTypeRule returns [EObject current=null] : ( () otherlv_1= 'boolean' ) ;
    public final EObject ruleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1957:2: ( ( () otherlv_1= 'boolean' ) )
            // InternalDefinitionLanguage.g:1958:2: ( () otherlv_1= 'boolean' )
            {
            // InternalDefinitionLanguage.g:1958:2: ( () otherlv_1= 'boolean' )
            // InternalDefinitionLanguage.g:1959:3: () otherlv_1= 'boolean'
            {
            // InternalDefinitionLanguage.g:1959:3: ()
            // InternalDefinitionLanguage.g:1960:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,42,FOLLOW_2); 

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
    // InternalDefinitionLanguage.g:1974:1: entryRuleVoidTypeRule returns [EObject current=null] : iv_ruleVoidTypeRule= ruleVoidTypeRule EOF ;
    public final EObject entryRuleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVoidTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:1974:53: (iv_ruleVoidTypeRule= ruleVoidTypeRule EOF )
            // InternalDefinitionLanguage.g:1975:2: iv_ruleVoidTypeRule= ruleVoidTypeRule EOF
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
    // InternalDefinitionLanguage.g:1981:1: ruleVoidTypeRule returns [EObject current=null] : ( () otherlv_1= 'void' ) ;
    public final EObject ruleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:1987:2: ( ( () otherlv_1= 'void' ) )
            // InternalDefinitionLanguage.g:1988:2: ( () otherlv_1= 'void' )
            {
            // InternalDefinitionLanguage.g:1988:2: ( () otherlv_1= 'void' )
            // InternalDefinitionLanguage.g:1989:3: () otherlv_1= 'void'
            {
            // InternalDefinitionLanguage.g:1989:3: ()
            // InternalDefinitionLanguage.g:1990:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,43,FOLLOW_2); 

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
    // InternalDefinitionLanguage.g:2004:1: entryRuleDataTypeRule returns [EObject current=null] : iv_ruleDataTypeRule= ruleDataTypeRule EOF ;
    public final EObject entryRuleDataTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:2004:53: (iv_ruleDataTypeRule= ruleDataTypeRule EOF )
            // InternalDefinitionLanguage.g:2005:2: iv_ruleDataTypeRule= ruleDataTypeRule EOF
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
    // InternalDefinitionLanguage.g:2011:1: ruleDataTypeRule returns [EObject current=null] : ( () otherlv_1= 'data' ) ;
    public final EObject ruleDataTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2017:2: ( ( () otherlv_1= 'data' ) )
            // InternalDefinitionLanguage.g:2018:2: ( () otherlv_1= 'data' )
            {
            // InternalDefinitionLanguage.g:2018:2: ( () otherlv_1= 'data' )
            // InternalDefinitionLanguage.g:2019:3: () otherlv_1= 'data'
            {
            // InternalDefinitionLanguage.g:2019:3: ()
            // InternalDefinitionLanguage.g:2020:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,44,FOLLOW_2); 

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
    // InternalDefinitionLanguage.g:2034:1: entryRuleArrayTypeRule returns [EObject current=null] : iv_ruleArrayTypeRule= ruleArrayTypeRule EOF ;
    public final EObject entryRuleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayTypeRule = null;


        try {
            // InternalDefinitionLanguage.g:2034:54: (iv_ruleArrayTypeRule= ruleArrayTypeRule EOF )
            // InternalDefinitionLanguage.g:2035:2: iv_ruleArrayTypeRule= ruleArrayTypeRule EOF
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
    // InternalDefinitionLanguage.g:2041:1: ruleArrayTypeRule returns [EObject current=null] : (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) ;
    public final EObject ruleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_elements_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2047:2: ( (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) )
            // InternalDefinitionLanguage.g:2048:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            {
            // InternalDefinitionLanguage.g:2048:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            // InternalDefinitionLanguage.g:2049:3: otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) )
            {
            otherlv_0=(Token)match(input,45,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0());
            		
            // InternalDefinitionLanguage.g:2053:3: ( (lv_elements_1_0= ruleTypeRule ) )
            // InternalDefinitionLanguage.g:2054:4: (lv_elements_1_0= ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:2054:4: (lv_elements_1_0= ruleTypeRule )
            // InternalDefinitionLanguage.g:2055:5: lv_elements_1_0= ruleTypeRule
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


    // $ANTLR start "entryRuleFunctionDefinitionRule"
    // InternalDefinitionLanguage.g:2076:1: entryRuleFunctionDefinitionRule returns [EObject current=null] : iv_ruleFunctionDefinitionRule= ruleFunctionDefinitionRule EOF ;
    public final EObject entryRuleFunctionDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinitionRule = null;


        try {
            // InternalDefinitionLanguage.g:2076:63: (iv_ruleFunctionDefinitionRule= ruleFunctionDefinitionRule EOF )
            // InternalDefinitionLanguage.g:2077:2: iv_ruleFunctionDefinitionRule= ruleFunctionDefinitionRule EOF
            {
             newCompositeNode(grammarAccess.getFunctionDefinitionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionDefinitionRule=ruleFunctionDefinitionRule();

            state._fsp--;

             current =iv_ruleFunctionDefinitionRule; 
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
    // $ANTLR end "entryRuleFunctionDefinitionRule"


    // $ANTLR start "ruleFunctionDefinitionRule"
    // InternalDefinitionLanguage.g:2083:1: ruleFunctionDefinitionRule returns [EObject current=null] : (otherlv_0= 'def' ( (lv_type_1_0= ruleTypeRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameterRule ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameterRule ) ) )* )? otherlv_7= ')' otherlv_8= ';' ) ;
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
            // InternalDefinitionLanguage.g:2089:2: ( (otherlv_0= 'def' ( (lv_type_1_0= ruleTypeRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameterRule ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameterRule ) ) )* )? otherlv_7= ')' otherlv_8= ';' ) )
            // InternalDefinitionLanguage.g:2090:2: (otherlv_0= 'def' ( (lv_type_1_0= ruleTypeRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameterRule ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameterRule ) ) )* )? otherlv_7= ')' otherlv_8= ';' )
            {
            // InternalDefinitionLanguage.g:2090:2: (otherlv_0= 'def' ( (lv_type_1_0= ruleTypeRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameterRule ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameterRule ) ) )* )? otherlv_7= ')' otherlv_8= ';' )
            // InternalDefinitionLanguage.g:2091:3: otherlv_0= 'def' ( (lv_type_1_0= ruleTypeRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameterRule ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameterRule ) ) )* )? otherlv_7= ')' otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,46,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getFunctionDefinitionRuleAccess().getDefKeyword_0());
            		
            // InternalDefinitionLanguage.g:2095:3: ( (lv_type_1_0= ruleTypeRule ) )
            // InternalDefinitionLanguage.g:2096:4: (lv_type_1_0= ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:2096:4: (lv_type_1_0= ruleTypeRule )
            // InternalDefinitionLanguage.g:2097:5: lv_type_1_0= ruleTypeRule
            {

            					newCompositeNode(grammarAccess.getFunctionDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_type_1_0=ruleTypeRule();

            state._fsp--;


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

            // InternalDefinitionLanguage.g:2114:3: ( (lv_name_2_0= ruleStringOrId ) )
            // InternalDefinitionLanguage.g:2115:4: (lv_name_2_0= ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:2115:4: (lv_name_2_0= ruleStringOrId )
            // InternalDefinitionLanguage.g:2116:5: lv_name_2_0= ruleStringOrId
            {

            					newCompositeNode(grammarAccess.getFunctionDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_17);
            lv_name_2_0=ruleStringOrId();

            state._fsp--;


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

            otherlv_3=(Token)match(input,25,FOLLOW_28); 

            			newLeafNode(otherlv_3, grammarAccess.getFunctionDefinitionRuleAccess().getLeftParenthesisKeyword_3());
            		
            // InternalDefinitionLanguage.g:2137:3: ( ( (lv_parameters_4_0= ruleParameterRule ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameterRule ) ) )* )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=35 && LA27_0<=36)||(LA27_0>=38 && LA27_0<=45)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalDefinitionLanguage.g:2138:4: ( (lv_parameters_4_0= ruleParameterRule ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameterRule ) ) )*
                    {
                    // InternalDefinitionLanguage.g:2138:4: ( (lv_parameters_4_0= ruleParameterRule ) )
                    // InternalDefinitionLanguage.g:2139:5: (lv_parameters_4_0= ruleParameterRule )
                    {
                    // InternalDefinitionLanguage.g:2139:5: (lv_parameters_4_0= ruleParameterRule )
                    // InternalDefinitionLanguage.g:2140:6: lv_parameters_4_0= ruleParameterRule
                    {

                    						newCompositeNode(grammarAccess.getFunctionDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_19);
                    lv_parameters_4_0=ruleParameterRule();

                    state._fsp--;


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

                    // InternalDefinitionLanguage.g:2157:4: (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameterRule ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==27) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalDefinitionLanguage.g:2158:5: otherlv_5= ',' ( (lv_parameters_6_0= ruleParameterRule ) )
                    	    {
                    	    otherlv_5=(Token)match(input,27,FOLLOW_25); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getFunctionDefinitionRuleAccess().getCommaKeyword_4_1_0());
                    	    				
                    	    // InternalDefinitionLanguage.g:2162:5: ( (lv_parameters_6_0= ruleParameterRule ) )
                    	    // InternalDefinitionLanguage.g:2163:6: (lv_parameters_6_0= ruleParameterRule )
                    	    {
                    	    // InternalDefinitionLanguage.g:2163:6: (lv_parameters_6_0= ruleParameterRule )
                    	    // InternalDefinitionLanguage.g:2164:7: lv_parameters_6_0= ruleParameterRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getFunctionDefinitionRuleAccess().getParametersParameterRuleParserRuleCall_4_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_19);
                    	    lv_parameters_6_0=ruleParameterRule();

                    	    state._fsp--;


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
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,26,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getFunctionDefinitionRuleAccess().getRightParenthesisKeyword_5());
            		
            otherlv_8=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getFunctionDefinitionRuleAccess().getSemicolonKeyword_6());
            		

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
    // $ANTLR end "ruleFunctionDefinitionRule"


    // $ANTLR start "entryRuleConstantDefinitionRule"
    // InternalDefinitionLanguage.g:2195:1: entryRuleConstantDefinitionRule returns [EObject current=null] : iv_ruleConstantDefinitionRule= ruleConstantDefinitionRule EOF ;
    public final EObject entryRuleConstantDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDefinitionRule = null;


        try {
            // InternalDefinitionLanguage.g:2195:63: (iv_ruleConstantDefinitionRule= ruleConstantDefinitionRule EOF )
            // InternalDefinitionLanguage.g:2196:2: iv_ruleConstantDefinitionRule= ruleConstantDefinitionRule EOF
            {
             newCompositeNode(grammarAccess.getConstantDefinitionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstantDefinitionRule=ruleConstantDefinitionRule();

            state._fsp--;

             current =iv_ruleConstantDefinitionRule; 
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
    // $ANTLR end "entryRuleConstantDefinitionRule"


    // $ANTLR start "ruleConstantDefinitionRule"
    // InternalDefinitionLanguage.g:2202:1: ruleConstantDefinitionRule returns [EObject current=null] : (otherlv_0= 'const' ( (lv_type_1_0= ruleTypeDefinitionRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= ':=' ( (lv_value_4_0= ruleExpressionRule ) ) ) ;
    public final EObject ruleConstantDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2208:2: ( (otherlv_0= 'const' ( (lv_type_1_0= ruleTypeDefinitionRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= ':=' ( (lv_value_4_0= ruleExpressionRule ) ) ) )
            // InternalDefinitionLanguage.g:2209:2: (otherlv_0= 'const' ( (lv_type_1_0= ruleTypeDefinitionRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= ':=' ( (lv_value_4_0= ruleExpressionRule ) ) )
            {
            // InternalDefinitionLanguage.g:2209:2: (otherlv_0= 'const' ( (lv_type_1_0= ruleTypeDefinitionRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= ':=' ( (lv_value_4_0= ruleExpressionRule ) ) )
            // InternalDefinitionLanguage.g:2210:3: otherlv_0= 'const' ( (lv_type_1_0= ruleTypeDefinitionRule ) ) ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= ':=' ( (lv_value_4_0= ruleExpressionRule ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_29); 

            			newLeafNode(otherlv_0, grammarAccess.getConstantDefinitionRuleAccess().getConstKeyword_0());
            		
            // InternalDefinitionLanguage.g:2214:3: ( (lv_type_1_0= ruleTypeDefinitionRule ) )
            // InternalDefinitionLanguage.g:2215:4: (lv_type_1_0= ruleTypeDefinitionRule )
            {
            // InternalDefinitionLanguage.g:2215:4: (lv_type_1_0= ruleTypeDefinitionRule )
            // InternalDefinitionLanguage.g:2216:5: lv_type_1_0= ruleTypeDefinitionRule
            {

            					newCompositeNode(grammarAccess.getConstantDefinitionRuleAccess().getTypeTypeDefinitionRuleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_type_1_0=ruleTypeDefinitionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstantDefinitionRuleRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"de.evoal.languages.model.base.dsl.BaseLanguage.TypeDefinitionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDefinitionLanguage.g:2233:3: ( (lv_name_2_0= ruleStringOrId ) )
            // InternalDefinitionLanguage.g:2234:4: (lv_name_2_0= ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:2234:4: (lv_name_2_0= ruleStringOrId )
            // InternalDefinitionLanguage.g:2235:5: lv_name_2_0= ruleStringOrId
            {

            					newCompositeNode(grammarAccess.getConstantDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_30);
            lv_name_2_0=ruleStringOrId();

            state._fsp--;


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

            otherlv_3=(Token)match(input,34,FOLLOW_9); 

            			newLeafNode(otherlv_3, grammarAccess.getConstantDefinitionRuleAccess().getColonEqualsSignKeyword_3());
            		
            // InternalDefinitionLanguage.g:2256:3: ( (lv_value_4_0= ruleExpressionRule ) )
            // InternalDefinitionLanguage.g:2257:4: (lv_value_4_0= ruleExpressionRule )
            {
            // InternalDefinitionLanguage.g:2257:4: (lv_value_4_0= ruleExpressionRule )
            // InternalDefinitionLanguage.g:2258:5: lv_value_4_0= ruleExpressionRule
            {

            					newCompositeNode(grammarAccess.getConstantDefinitionRuleAccess().getValueExpressionRuleParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_4_0=ruleExpressionRule();

            state._fsp--;


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
    // $ANTLR end "ruleConstantDefinitionRule"


    // $ANTLR start "entryRuleParameterRule"
    // InternalDefinitionLanguage.g:2279:1: entryRuleParameterRule returns [EObject current=null] : iv_ruleParameterRule= ruleParameterRule EOF ;
    public final EObject entryRuleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRule = null;


        try {
            // InternalDefinitionLanguage.g:2279:54: (iv_ruleParameterRule= ruleParameterRule EOF )
            // InternalDefinitionLanguage.g:2280:2: iv_ruleParameterRule= ruleParameterRule EOF
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
    // InternalDefinitionLanguage.g:2286:1: ruleParameterRule returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) ;
    public final EObject ruleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2292:2: ( ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) )
            // InternalDefinitionLanguage.g:2293:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            {
            // InternalDefinitionLanguage.g:2293:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            // InternalDefinitionLanguage.g:2294:3: ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) )
            {
            // InternalDefinitionLanguage.g:2294:3: ( (lv_type_0_0= ruleTypeRule ) )
            // InternalDefinitionLanguage.g:2295:4: (lv_type_0_0= ruleTypeRule )
            {
            // InternalDefinitionLanguage.g:2295:4: (lv_type_0_0= ruleTypeRule )
            // InternalDefinitionLanguage.g:2296:5: lv_type_0_0= ruleTypeRule
            {

            					newCompositeNode(grammarAccess.getParameterRuleAccess().getTypeTypeRuleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
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

            // InternalDefinitionLanguage.g:2313:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalDefinitionLanguage.g:2314:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalDefinitionLanguage.g:2314:4: (lv_name_1_0= ruleStringOrId )
            // InternalDefinitionLanguage.g:2315:5: lv_name_1_0= ruleStringOrId
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
    // InternalDefinitionLanguage.g:2336:1: entryRuleFunctionNameRule returns [EObject current=null] : iv_ruleFunctionNameRule= ruleFunctionNameRule EOF ;
    public final EObject entryRuleFunctionNameRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionNameRule = null;


        try {
            // InternalDefinitionLanguage.g:2336:57: (iv_ruleFunctionNameRule= ruleFunctionNameRule EOF )
            // InternalDefinitionLanguage.g:2337:2: iv_ruleFunctionNameRule= ruleFunctionNameRule EOF
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
    // InternalDefinitionLanguage.g:2343:1: ruleFunctionNameRule returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleFunctionNameRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2349:2: ( ( ( ruleQualifiedName ) ) )
            // InternalDefinitionLanguage.g:2350:2: ( ( ruleQualifiedName ) )
            {
            // InternalDefinitionLanguage.g:2350:2: ( ( ruleQualifiedName ) )
            // InternalDefinitionLanguage.g:2351:3: ( ruleQualifiedName )
            {
            // InternalDefinitionLanguage.g:2351:3: ( ruleQualifiedName )
            // InternalDefinitionLanguage.g:2352:4: ruleQualifiedName
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
    // InternalDefinitionLanguage.g:2369:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalDefinitionLanguage.g:2369:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalDefinitionLanguage.g:2370:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalDefinitionLanguage.g:2376:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_StringOrId_0 = null;

        AntlrDatatypeRuleToken this_StringOrId_2 = null;



        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2382:2: ( (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) )
            // InternalDefinitionLanguage.g:2383:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            {
            // InternalDefinitionLanguage.g:2383:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            // InternalDefinitionLanguage.g:2384:3: this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )*
            {

            			newCompositeNode(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_0());
            		
            pushFollow(FOLLOW_31);
            this_StringOrId_0=ruleStringOrId();

            state._fsp--;


            			current.merge(this_StringOrId_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalDefinitionLanguage.g:2394:3: (kw= '.' this_StringOrId_2= ruleStringOrId )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==48) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalDefinitionLanguage.g:2395:4: kw= '.' this_StringOrId_2= ruleStringOrId
            	    {
            	    kw=(Token)match(input,48,FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			

            	    				newCompositeNode(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_1_1());
            	    			
            	    pushFollow(FOLLOW_31);
            	    this_StringOrId_2=ruleStringOrId();

            	    state._fsp--;


            	    				current.merge(this_StringOrId_2);
            	    			

            	    				afterParserOrEnumRuleCall();
            	    			

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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleStringOrId"
    // InternalDefinitionLanguage.g:2415:1: entryRuleStringOrId returns [String current=null] : iv_ruleStringOrId= ruleStringOrId EOF ;
    public final String entryRuleStringOrId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringOrId = null;


        try {
            // InternalDefinitionLanguage.g:2415:50: (iv_ruleStringOrId= ruleStringOrId EOF )
            // InternalDefinitionLanguage.g:2416:2: iv_ruleStringOrId= ruleStringOrId EOF
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
    // InternalDefinitionLanguage.g:2422:1: ruleStringOrId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleStringOrId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_QUOTED_ID_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2428:2: ( (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) )
            // InternalDefinitionLanguage.g:2429:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            {
            // InternalDefinitionLanguage.g:2429:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_QUOTED_ID) ) {
                alt29=1;
            }
            else if ( (LA29_0==RULE_ID) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalDefinitionLanguage.g:2430:3: this_QUOTED_ID_0= RULE_QUOTED_ID
                    {
                    this_QUOTED_ID_0=(Token)match(input,RULE_QUOTED_ID,FOLLOW_2); 

                    			current.merge(this_QUOTED_ID_0);
                    		

                    			newLeafNode(this_QUOTED_ID_0, grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:2438:3: this_ID_1= RULE_ID
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
    // InternalDefinitionLanguage.g:2449:1: ruleComparisonOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) ;
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
            // InternalDefinitionLanguage.g:2455:2: ( ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) )
            // InternalDefinitionLanguage.g:2456:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalDefinitionLanguage.g:2456:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            int alt30=6;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt30=1;
                }
                break;
            case 50:
                {
                alt30=2;
                }
                break;
            case 51:
                {
                alt30=3;
                }
                break;
            case 52:
                {
                alt30=4;
                }
                break;
            case 53:
                {
                alt30=5;
                }
                break;
            case 54:
                {
                alt30=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalDefinitionLanguage.g:2457:3: (enumLiteral_0= '>=' )
                    {
                    // InternalDefinitionLanguage.g:2457:3: (enumLiteral_0= '>=' )
                    // InternalDefinitionLanguage.g:2458:4: enumLiteral_0= '>='
                    {
                    enumLiteral_0=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:2465:3: (enumLiteral_1= '>' )
                    {
                    // InternalDefinitionLanguage.g:2465:3: (enumLiteral_1= '>' )
                    // InternalDefinitionLanguage.g:2466:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:2473:3: (enumLiteral_2= '=' )
                    {
                    // InternalDefinitionLanguage.g:2473:3: (enumLiteral_2= '=' )
                    // InternalDefinitionLanguage.g:2474:4: enumLiteral_2= '='
                    {
                    enumLiteral_2=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDefinitionLanguage.g:2481:3: (enumLiteral_3= '!=' )
                    {
                    // InternalDefinitionLanguage.g:2481:3: (enumLiteral_3= '!=' )
                    // InternalDefinitionLanguage.g:2482:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDefinitionLanguage.g:2489:3: (enumLiteral_4= '<' )
                    {
                    // InternalDefinitionLanguage.g:2489:3: (enumLiteral_4= '<' )
                    // InternalDefinitionLanguage.g:2490:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalDefinitionLanguage.g:2497:3: (enumLiteral_5= '<=' )
                    {
                    // InternalDefinitionLanguage.g:2497:3: (enumLiteral_5= '<=' )
                    // InternalDefinitionLanguage.g:2498:4: enumLiteral_5= '<='
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
    // InternalDefinitionLanguage.g:2508:1: ruleAddOrSubtractOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOrSubtractOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2514:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalDefinitionLanguage.g:2515:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalDefinitionLanguage.g:2515:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==55) ) {
                alt31=1;
            }
            else if ( (LA31_0==56) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalDefinitionLanguage.g:2516:3: (enumLiteral_0= '+' )
                    {
                    // InternalDefinitionLanguage.g:2516:3: (enumLiteral_0= '+' )
                    // InternalDefinitionLanguage.g:2517:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:2524:3: (enumLiteral_1= '-' )
                    {
                    // InternalDefinitionLanguage.g:2524:3: (enumLiteral_1= '-' )
                    // InternalDefinitionLanguage.g:2525:4: enumLiteral_1= '-'
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
    // InternalDefinitionLanguage.g:2535:1: ruleMultiplyDivideModuloOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalDefinitionLanguage.g:2541:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalDefinitionLanguage.g:2542:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalDefinitionLanguage.g:2542:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt32=3;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt32=1;
                }
                break;
            case 58:
                {
                alt32=2;
                }
                break;
            case 59:
                {
                alt32=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalDefinitionLanguage.g:2543:3: (enumLiteral_0= '*' )
                    {
                    // InternalDefinitionLanguage.g:2543:3: (enumLiteral_0= '*' )
                    // InternalDefinitionLanguage.g:2544:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:2551:3: (enumLiteral_1= '/' )
                    {
                    // InternalDefinitionLanguage.g:2551:3: (enumLiteral_1= '/' )
                    // InternalDefinitionLanguage.g:2552:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:2559:3: (enumLiteral_2= '%' )
                    {
                    // InternalDefinitionLanguage.g:2559:3: (enumLiteral_2= '%' )
                    // InternalDefinitionLanguage.g:2560:4: enumLiteral_2= '%'
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
    // InternalDefinitionLanguage.g:2570:1: ruleFactorRule returns [Enumerator current=null] : ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) ;
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
            // InternalDefinitionLanguage.g:2576:2: ( ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) )
            // InternalDefinitionLanguage.g:2577:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            {
            // InternalDefinitionLanguage.g:2577:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            int alt33=20;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt33=1;
                }
                break;
            case 61:
                {
                alt33=2;
                }
                break;
            case 62:
                {
                alt33=3;
                }
                break;
            case 63:
                {
                alt33=4;
                }
                break;
            case 64:
                {
                alt33=5;
                }
                break;
            case 65:
                {
                alt33=6;
                }
                break;
            case 66:
                {
                alt33=7;
                }
                break;
            case 67:
                {
                alt33=8;
                }
                break;
            case 68:
                {
                alt33=9;
                }
                break;
            case 69:
                {
                alt33=10;
                }
                break;
            case 70:
                {
                alt33=11;
                }
                break;
            case 71:
                {
                alt33=12;
                }
                break;
            case 72:
                {
                alt33=13;
                }
                break;
            case 73:
                {
                alt33=14;
                }
                break;
            case 74:
                {
                alt33=15;
                }
                break;
            case 75:
                {
                alt33=16;
                }
                break;
            case 76:
                {
                alt33=17;
                }
                break;
            case 77:
                {
                alt33=18;
                }
                break;
            case 78:
                {
                alt33=19;
                }
                break;
            case 79:
                {
                alt33=20;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalDefinitionLanguage.g:2578:3: (enumLiteral_0= 'Y' )
                    {
                    // InternalDefinitionLanguage.g:2578:3: (enumLiteral_0= 'Y' )
                    // InternalDefinitionLanguage.g:2579:4: enumLiteral_0= 'Y'
                    {
                    enumLiteral_0=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDefinitionLanguage.g:2586:3: (enumLiteral_1= 'Z' )
                    {
                    // InternalDefinitionLanguage.g:2586:3: (enumLiteral_1= 'Z' )
                    // InternalDefinitionLanguage.g:2587:4: enumLiteral_1= 'Z'
                    {
                    enumLiteral_1=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDefinitionLanguage.g:2594:3: (enumLiteral_2= 'E' )
                    {
                    // InternalDefinitionLanguage.g:2594:3: (enumLiteral_2= 'E' )
                    // InternalDefinitionLanguage.g:2595:4: enumLiteral_2= 'E'
                    {
                    enumLiteral_2=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDefinitionLanguage.g:2602:3: (enumLiteral_3= 'P' )
                    {
                    // InternalDefinitionLanguage.g:2602:3: (enumLiteral_3= 'P' )
                    // InternalDefinitionLanguage.g:2603:4: enumLiteral_3= 'P'
                    {
                    enumLiteral_3=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDefinitionLanguage.g:2610:3: (enumLiteral_4= 'T' )
                    {
                    // InternalDefinitionLanguage.g:2610:3: (enumLiteral_4= 'T' )
                    // InternalDefinitionLanguage.g:2611:4: enumLiteral_4= 'T'
                    {
                    enumLiteral_4=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalDefinitionLanguage.g:2618:3: (enumLiteral_5= 'G' )
                    {
                    // InternalDefinitionLanguage.g:2618:3: (enumLiteral_5= 'G' )
                    // InternalDefinitionLanguage.g:2619:4: enumLiteral_5= 'G'
                    {
                    enumLiteral_5=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalDefinitionLanguage.g:2626:3: (enumLiteral_6= 'M' )
                    {
                    // InternalDefinitionLanguage.g:2626:3: (enumLiteral_6= 'M' )
                    // InternalDefinitionLanguage.g:2627:4: enumLiteral_6= 'M'
                    {
                    enumLiteral_6=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalDefinitionLanguage.g:2634:3: (enumLiteral_7= 'k' )
                    {
                    // InternalDefinitionLanguage.g:2634:3: (enumLiteral_7= 'k' )
                    // InternalDefinitionLanguage.g:2635:4: enumLiteral_7= 'k'
                    {
                    enumLiteral_7=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalDefinitionLanguage.g:2642:3: (enumLiteral_8= 'h' )
                    {
                    // InternalDefinitionLanguage.g:2642:3: (enumLiteral_8= 'h' )
                    // InternalDefinitionLanguage.g:2643:4: enumLiteral_8= 'h'
                    {
                    enumLiteral_8=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalDefinitionLanguage.g:2650:3: (enumLiteral_9= 'da' )
                    {
                    // InternalDefinitionLanguage.g:2650:3: (enumLiteral_9= 'da' )
                    // InternalDefinitionLanguage.g:2651:4: enumLiteral_9= 'da'
                    {
                    enumLiteral_9=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalDefinitionLanguage.g:2658:3: (enumLiteral_10= 'd' )
                    {
                    // InternalDefinitionLanguage.g:2658:3: (enumLiteral_10= 'd' )
                    // InternalDefinitionLanguage.g:2659:4: enumLiteral_10= 'd'
                    {
                    enumLiteral_10=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalDefinitionLanguage.g:2666:3: (enumLiteral_11= 'c' )
                    {
                    // InternalDefinitionLanguage.g:2666:3: (enumLiteral_11= 'c' )
                    // InternalDefinitionLanguage.g:2667:4: enumLiteral_11= 'c'
                    {
                    enumLiteral_11=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalDefinitionLanguage.g:2674:3: (enumLiteral_12= 'm' )
                    {
                    // InternalDefinitionLanguage.g:2674:3: (enumLiteral_12= 'm' )
                    // InternalDefinitionLanguage.g:2675:4: enumLiteral_12= 'm'
                    {
                    enumLiteral_12=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalDefinitionLanguage.g:2682:3: (enumLiteral_13= '\\u00B5' )
                    {
                    // InternalDefinitionLanguage.g:2682:3: (enumLiteral_13= '\\u00B5' )
                    // InternalDefinitionLanguage.g:2683:4: enumLiteral_13= '\\u00B5'
                    {
                    enumLiteral_13=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalDefinitionLanguage.g:2690:3: (enumLiteral_14= 'n' )
                    {
                    // InternalDefinitionLanguage.g:2690:3: (enumLiteral_14= 'n' )
                    // InternalDefinitionLanguage.g:2691:4: enumLiteral_14= 'n'
                    {
                    enumLiteral_14=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalDefinitionLanguage.g:2698:3: (enumLiteral_15= 'p' )
                    {
                    // InternalDefinitionLanguage.g:2698:3: (enumLiteral_15= 'p' )
                    // InternalDefinitionLanguage.g:2699:4: enumLiteral_15= 'p'
                    {
                    enumLiteral_15=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalDefinitionLanguage.g:2706:3: (enumLiteral_16= 'f' )
                    {
                    // InternalDefinitionLanguage.g:2706:3: (enumLiteral_16= 'f' )
                    // InternalDefinitionLanguage.g:2707:4: enumLiteral_16= 'f'
                    {
                    enumLiteral_16=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalDefinitionLanguage.g:2714:3: (enumLiteral_17= 'a' )
                    {
                    // InternalDefinitionLanguage.g:2714:3: (enumLiteral_17= 'a' )
                    // InternalDefinitionLanguage.g:2715:4: enumLiteral_17= 'a'
                    {
                    enumLiteral_17=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalDefinitionLanguage.g:2722:3: (enumLiteral_18= 'z' )
                    {
                    // InternalDefinitionLanguage.g:2722:3: (enumLiteral_18= 'z' )
                    // InternalDefinitionLanguage.g:2723:4: enumLiteral_18= 'z'
                    {
                    enumLiteral_18=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalDefinitionLanguage.g:2730:3: (enumLiteral_19= 'y' )
                    {
                    // InternalDefinitionLanguage.g:2730:3: (enumLiteral_19= 'y' )
                    // InternalDefinitionLanguage.g:2731:4: enumLiteral_19= 'y'
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


    protected DFA12 dfa12 = new DFA12(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\uffff\2\6\5\uffff\2\6";
    static final String dfa_3s = "\1\4\2\21\2\uffff\1\7\2\uffff\2\21";
    static final String dfa_4s = "\1\35\2\73\2\uffff\1\10\2\uffff\2\73";
    static final String dfa_5s = "\3\uffff\1\2\1\3\1\uffff\1\4\1\1\2\uffff";
    static final String dfa_6s = "\12\uffff}>";
    static final String[] dfa_7s = {
            "\3\3\1\1\1\2\20\uffff\1\4\2\uffff\2\3",
            "\1\6\1\uffff\4\6\1\uffff\1\6\1\7\2\6\2\uffff\2\6\16\uffff\2\6\1\5\13\6",
            "\1\6\1\uffff\4\6\1\uffff\1\6\1\7\2\6\2\uffff\2\6\16\uffff\2\6\1\5\13\6",
            "",
            "",
            "\1\10\1\11",
            "",
            "",
            "\1\6\1\uffff\4\6\1\uffff\1\6\1\7\2\6\2\uffff\2\6\16\uffff\2\6\1\5\13\6",
            "\1\6\1\uffff\4\6\1\uffff\1\6\1\7\2\6\2\uffff\2\6\16\uffff\2\6\1\5\13\6"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "912:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000C000C0020000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x01800000328001F0L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x007E000000000002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0180000000000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0E00000000000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x01800000368001F0L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0xF000000000000002L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000100010000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000020180L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00003FD800000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000400080000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x00003FD804000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0001000000000002L});

}
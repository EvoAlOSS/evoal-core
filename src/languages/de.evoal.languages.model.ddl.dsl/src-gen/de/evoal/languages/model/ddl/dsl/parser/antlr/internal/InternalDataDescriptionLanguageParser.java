package de.evoal.languages.model.ddl.dsl.parser.antlr.internal;

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
import de.evoal.languages.model.ddl.dsl.services.DataDescriptionLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalDataDescriptionLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_DOUBLE", "RULE_INT", "RULE_QUOTED_ID", "RULE_ID", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'module'", "'{'", "'types'", "':'", "'data'", "'constraints'", "'}'", "'import'", "';'", "'type'", "'description'", "'with'", "'of'", "'value'", "'OR'", "'XOR'", "'AND'", "'!'", "'^'", "'['", "','", "']'", "'('", "')'", "':='", "'true'", "'false'", "'literal'", "'instance'", "'|'", "'string'", "'expression'", "'int'", "'float'", "'boolean'", "'void'", "'array'", "'.'", "'nominal'", "'ordinal'", "'cardinal'", "'quotient'", "'real'", "'integer'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'"
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
    public static final int RULE_INT=6;
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
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__37=37;
    public static final int RULE_DOUBLE=5;
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
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_EXPONENT=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__88=88;
    public static final int T__45=45;
    public static final int T__89=89;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int T__42=42;
    public static final int T__86=86;
    public static final int T__43=43;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalDataDescriptionLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDataDescriptionLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDataDescriptionLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDataDescriptionLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private DataDescriptionLanguageGrammarAccess grammarAccess;

        public InternalDataDescriptionLanguageParser(TokenStream input, DataDescriptionLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "DataDescriptionModelRule";
       	}

       	@Override
       	protected DataDescriptionLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleDataDescriptionModelRule"
    // InternalDataDescriptionLanguage.g:72:1: entryRuleDataDescriptionModelRule returns [EObject current=null] : iv_ruleDataDescriptionModelRule= ruleDataDescriptionModelRule EOF ;
    public final EObject entryRuleDataDescriptionModelRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataDescriptionModelRule = null;


        try {
            // InternalDataDescriptionLanguage.g:72:65: (iv_ruleDataDescriptionModelRule= ruleDataDescriptionModelRule EOF )
            // InternalDataDescriptionLanguage.g:73:2: iv_ruleDataDescriptionModelRule= ruleDataDescriptionModelRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataDescriptionModelRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDataDescriptionModelRule=ruleDataDescriptionModelRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataDescriptionModelRule; 
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
    // $ANTLR end "entryRuleDataDescriptionModelRule"


    // $ANTLR start "ruleDataDescriptionModelRule"
    // InternalDataDescriptionLanguage.g:79:1: ruleDataDescriptionModelRule returns [EObject current=null] : ( () ( (lv_imports_1_0= ruleImportRule ) )* otherlv_2= 'module' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= '{' (otherlv_5= 'types' otherlv_6= ':' ( (lv_types_7_0= ruleDataTypeDefinitionRule ) )* )? (otherlv_8= 'data' otherlv_9= ':' ( (lv_descriptions_10_0= ruleDataDescriptionRule ) )* )? (otherlv_11= 'constraints' otherlv_12= ':' ( (lv_constraints_13_0= ruleStatementRule ) )* )? otherlv_14= '}' ) ;
    public final EObject ruleDataDescriptionModelRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject lv_imports_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_types_7_0 = null;

        EObject lv_descriptions_10_0 = null;

        EObject lv_constraints_13_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:85:2: ( ( () ( (lv_imports_1_0= ruleImportRule ) )* otherlv_2= 'module' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= '{' (otherlv_5= 'types' otherlv_6= ':' ( (lv_types_7_0= ruleDataTypeDefinitionRule ) )* )? (otherlv_8= 'data' otherlv_9= ':' ( (lv_descriptions_10_0= ruleDataDescriptionRule ) )* )? (otherlv_11= 'constraints' otherlv_12= ':' ( (lv_constraints_13_0= ruleStatementRule ) )* )? otherlv_14= '}' ) )
            // InternalDataDescriptionLanguage.g:86:2: ( () ( (lv_imports_1_0= ruleImportRule ) )* otherlv_2= 'module' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= '{' (otherlv_5= 'types' otherlv_6= ':' ( (lv_types_7_0= ruleDataTypeDefinitionRule ) )* )? (otherlv_8= 'data' otherlv_9= ':' ( (lv_descriptions_10_0= ruleDataDescriptionRule ) )* )? (otherlv_11= 'constraints' otherlv_12= ':' ( (lv_constraints_13_0= ruleStatementRule ) )* )? otherlv_14= '}' )
            {
            // InternalDataDescriptionLanguage.g:86:2: ( () ( (lv_imports_1_0= ruleImportRule ) )* otherlv_2= 'module' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= '{' (otherlv_5= 'types' otherlv_6= ':' ( (lv_types_7_0= ruleDataTypeDefinitionRule ) )* )? (otherlv_8= 'data' otherlv_9= ':' ( (lv_descriptions_10_0= ruleDataDescriptionRule ) )* )? (otherlv_11= 'constraints' otherlv_12= ':' ( (lv_constraints_13_0= ruleStatementRule ) )* )? otherlv_14= '}' )
            // InternalDataDescriptionLanguage.g:87:3: () ( (lv_imports_1_0= ruleImportRule ) )* otherlv_2= 'module' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= '{' (otherlv_5= 'types' otherlv_6= ':' ( (lv_types_7_0= ruleDataTypeDefinitionRule ) )* )? (otherlv_8= 'data' otherlv_9= ':' ( (lv_descriptions_10_0= ruleDataDescriptionRule ) )* )? (otherlv_11= 'constraints' otherlv_12= ':' ( (lv_constraints_13_0= ruleStatementRule ) )* )? otherlv_14= '}'
            {
            // InternalDataDescriptionLanguage.g:87:3: ()
            // InternalDataDescriptionLanguage.g:88:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDataDescriptionModelRuleAccess().getDataDescriptionModelAction_0(),
              					current);
              			
            }

            }

            // InternalDataDescriptionLanguage.g:97:3: ( (lv_imports_1_0= ruleImportRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==22) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:98:4: (lv_imports_1_0= ruleImportRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:98:4: (lv_imports_1_0= ruleImportRule )
            	    // InternalDataDescriptionLanguage.g:99:5: lv_imports_1_0= ruleImportRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getDataDescriptionModelRuleAccess().getImportsImportRuleParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_imports_1_0=ruleImportRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getDataDescriptionModelRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"imports",
            	      						lv_imports_1_0,
            	      						"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.ImportRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_2=(Token)match(input,15,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getDataDescriptionModelRuleAccess().getModuleKeyword_2());
              		
            }
            // InternalDataDescriptionLanguage.g:120:3: ( (lv_name_3_0= ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:121:4: (lv_name_3_0= ruleQualifiedName )
            {
            // InternalDataDescriptionLanguage.g:121:4: (lv_name_3_0= ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:122:5: lv_name_3_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDataDescriptionModelRuleAccess().getNameQualifiedNameParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_3_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDataDescriptionModelRuleRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_3_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.QualifiedName");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getDataDescriptionModelRuleAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalDataDescriptionLanguage.g:143:3: (otherlv_5= 'types' otherlv_6= ':' ( (lv_types_7_0= ruleDataTypeDefinitionRule ) )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:144:4: otherlv_5= 'types' otherlv_6= ':' ( (lv_types_7_0= ruleDataTypeDefinitionRule ) )*
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getDataDescriptionModelRuleAccess().getTypesKeyword_5_0());
                      			
                    }
                    otherlv_6=(Token)match(input,18,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_5_1());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:152:4: ( (lv_types_7_0= ruleDataTypeDefinitionRule ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>=53 && LA2_0<=56)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:153:5: (lv_types_7_0= ruleDataTypeDefinitionRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:153:5: (lv_types_7_0= ruleDataTypeDefinitionRule )
                    	    // InternalDataDescriptionLanguage.g:154:6: lv_types_7_0= ruleDataTypeDefinitionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getDataDescriptionModelRuleAccess().getTypesDataTypeDefinitionRuleParserRuleCall_5_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_8);
                    	    lv_types_7_0=ruleDataTypeDefinitionRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getDataDescriptionModelRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"types",
                    	      							lv_types_7_0,
                    	      							"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.DataTypeDefinitionRule");
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
                    break;

            }

            // InternalDataDescriptionLanguage.g:172:3: (otherlv_8= 'data' otherlv_9= ':' ( (lv_descriptions_10_0= ruleDataDescriptionRule ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:173:4: otherlv_8= 'data' otherlv_9= ':' ( (lv_descriptions_10_0= ruleDataDescriptionRule ) )*
                    {
                    otherlv_8=(Token)match(input,19,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getDataDescriptionModelRuleAccess().getDataKeyword_6_0());
                      			
                    }
                    otherlv_9=(Token)match(input,18,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_6_1());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:181:4: ( (lv_descriptions_10_0= ruleDataDescriptionRule ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==45||LA4_0==49||(LA4_0>=53 && LA4_0<=58)) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:182:5: (lv_descriptions_10_0= ruleDataDescriptionRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:182:5: (lv_descriptions_10_0= ruleDataDescriptionRule )
                    	    // InternalDataDescriptionLanguage.g:183:6: lv_descriptions_10_0= ruleDataDescriptionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getDataDescriptionModelRuleAccess().getDescriptionsDataDescriptionRuleParserRuleCall_6_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_9);
                    	    lv_descriptions_10_0=ruleDataDescriptionRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getDataDescriptionModelRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"descriptions",
                    	      							lv_descriptions_10_0,
                    	      							"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.DataDescriptionRule");
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

            // InternalDataDescriptionLanguage.g:201:3: (otherlv_11= 'constraints' otherlv_12= ':' ( (lv_constraints_13_0= ruleStatementRule ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:202:4: otherlv_11= 'constraints' otherlv_12= ':' ( (lv_constraints_13_0= ruleStatementRule ) )*
                    {
                    otherlv_11=(Token)match(input,20,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsKeyword_7_0());
                      			
                    }
                    otherlv_12=(Token)match(input,18,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_7_1());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:210:4: ( (lv_constraints_13_0= ruleStatementRule ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=RULE_STRING && LA6_0<=RULE_ID)||LA6_0==28||LA6_0==32||LA6_0==34||LA6_0==37||(LA6_0>=40 && LA6_0<=41)||(LA6_0>=65 && LA6_0<=66)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:211:5: (lv_constraints_13_0= ruleStatementRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:211:5: (lv_constraints_13_0= ruleStatementRule )
                    	    // InternalDataDescriptionLanguage.g:212:6: lv_constraints_13_0= ruleStatementRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsStatementRuleParserRuleCall_7_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_10);
                    	    lv_constraints_13_0=ruleStatementRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getDataDescriptionModelRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"constraints",
                    	      							lv_constraints_13_0,
                    	      							"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.StatementRule");
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
                    break;

            }

            otherlv_14=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_14, grammarAccess.getDataDescriptionModelRuleAccess().getRightCurlyBracketKeyword_8());
              		
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
    // $ANTLR end "ruleDataDescriptionModelRule"


    // $ANTLR start "entryRuleImportRule"
    // InternalDataDescriptionLanguage.g:238:1: entryRuleImportRule returns [EObject current=null] : iv_ruleImportRule= ruleImportRule EOF ;
    public final EObject entryRuleImportRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportRule = null;


        try {
            // InternalDataDescriptionLanguage.g:238:51: (iv_ruleImportRule= ruleImportRule EOF )
            // InternalDataDescriptionLanguage.g:239:2: iv_ruleImportRule= ruleImportRule EOF
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
    // InternalDataDescriptionLanguage.g:245:1: ruleImportRule returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) otherlv_2= ';' ) ;
    public final EObject ruleImportRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:251:2: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) otherlv_2= ';' ) )
            // InternalDataDescriptionLanguage.g:252:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) otherlv_2= ';' )
            {
            // InternalDataDescriptionLanguage.g:252:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) otherlv_2= ';' )
            // InternalDataDescriptionLanguage.g:253:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportRuleAccess().getImportKeyword_0());
              		
            }
            // InternalDataDescriptionLanguage.g:257:3: ( (lv_importedNamespace_1_0= ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:258:4: (lv_importedNamespace_1_0= ruleQualifiedName )
            {
            // InternalDataDescriptionLanguage.g:258:4: (lv_importedNamespace_1_0= ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:259:5: lv_importedNamespace_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getImportRuleAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_11);
            lv_importedNamespace_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            otherlv_2=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getImportRuleAccess().getSemicolonKeyword_2());
              		
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


    // $ANTLR start "entryRuleDataTypeDefinitionRule"
    // InternalDataDescriptionLanguage.g:284:1: entryRuleDataTypeDefinitionRule returns [EObject current=null] : iv_ruleDataTypeDefinitionRule= ruleDataTypeDefinitionRule EOF ;
    public final EObject entryRuleDataTypeDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeDefinitionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:284:63: (iv_ruleDataTypeDefinitionRule= ruleDataTypeDefinitionRule EOF )
            // InternalDataDescriptionLanguage.g:285:2: iv_ruleDataTypeDefinitionRule= ruleDataTypeDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypeDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDataTypeDefinitionRule=ruleDataTypeDefinitionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypeDefinitionRule; 
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
    // $ANTLR end "entryRuleDataTypeDefinitionRule"


    // $ANTLR start "ruleDataTypeDefinitionRule"
    // InternalDataDescriptionLanguage.g:291:1: ruleDataTypeDefinitionRule returns [EObject current=null] : ( ( (lv_scale_0_0= ruleScaleType ) ) otherlv_1= 'type' ( (lv_name_2_0= ruleStringOrId ) ) (otherlv_3= 'description' otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) ) )? (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';' ) ;
    public final EObject ruleDataTypeDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_description_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Enumerator lv_scale_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_constraints_9_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:297:2: ( ( ( (lv_scale_0_0= ruleScaleType ) ) otherlv_1= 'type' ( (lv_name_2_0= ruleStringOrId ) ) (otherlv_3= 'description' otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) ) )? (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';' ) )
            // InternalDataDescriptionLanguage.g:298:2: ( ( (lv_scale_0_0= ruleScaleType ) ) otherlv_1= 'type' ( (lv_name_2_0= ruleStringOrId ) ) (otherlv_3= 'description' otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) ) )? (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';' )
            {
            // InternalDataDescriptionLanguage.g:298:2: ( ( (lv_scale_0_0= ruleScaleType ) ) otherlv_1= 'type' ( (lv_name_2_0= ruleStringOrId ) ) (otherlv_3= 'description' otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) ) )? (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';' )
            // InternalDataDescriptionLanguage.g:299:3: ( (lv_scale_0_0= ruleScaleType ) ) otherlv_1= 'type' ( (lv_name_2_0= ruleStringOrId ) ) (otherlv_3= 'description' otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) ) )? (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';'
            {
            // InternalDataDescriptionLanguage.g:299:3: ( (lv_scale_0_0= ruleScaleType ) )
            // InternalDataDescriptionLanguage.g:300:4: (lv_scale_0_0= ruleScaleType )
            {
            // InternalDataDescriptionLanguage.g:300:4: (lv_scale_0_0= ruleScaleType )
            // InternalDataDescriptionLanguage.g:301:5: lv_scale_0_0= ruleScaleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDataTypeDefinitionRuleAccess().getScaleScaleTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_12);
            lv_scale_0_0=ruleScaleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDataTypeDefinitionRuleRule());
              					}
              					set(
              						current,
              						"scale",
              						lv_scale_0_0,
              						"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.ScaleType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDataTypeDefinitionRuleAccess().getTypeKeyword_1());
              		
            }
            // InternalDataDescriptionLanguage.g:322:3: ( (lv_name_2_0= ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:323:4: (lv_name_2_0= ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:323:4: (lv_name_2_0= ruleStringOrId )
            // InternalDataDescriptionLanguage.g:324:5: lv_name_2_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDataTypeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_name_2_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDataTypeDefinitionRuleRule());
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

            // InternalDataDescriptionLanguage.g:341:3: (otherlv_3= 'description' otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==25) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:342:4: otherlv_3= 'description' otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,25,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getDataTypeDefinitionRuleAccess().getDescriptionKeyword_3_0());
                      			
                    }
                    otherlv_4=(Token)match(input,18,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getDataTypeDefinitionRuleAccess().getColonKeyword_3_1());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:350:4: ( (lv_description_5_0= RULE_STRING ) )
                    // InternalDataDescriptionLanguage.g:351:5: (lv_description_5_0= RULE_STRING )
                    {
                    // InternalDataDescriptionLanguage.g:351:5: (lv_description_5_0= RULE_STRING )
                    // InternalDataDescriptionLanguage.g:352:6: lv_description_5_0= RULE_STRING
                    {
                    lv_description_5_0=(Token)match(input,RULE_STRING,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_description_5_0, grammarAccess.getDataTypeDefinitionRuleAccess().getDescriptionSTRINGTerminalRuleCall_3_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDataTypeDefinitionRuleRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"description",
                      							lv_description_5_0,
                      							"de.evoal.languages.model.base.dsl.BaseLanguage.STRING");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalDataDescriptionLanguage.g:369:3: (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==26) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:370:4: otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )*
                    {
                    otherlv_6=(Token)match(input,26,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getDataTypeDefinitionRuleAccess().getWithKeyword_4_0());
                      			
                    }
                    otherlv_7=(Token)match(input,20,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getDataTypeDefinitionRuleAccess().getConstraintsKeyword_4_1());
                      			
                    }
                    otherlv_8=(Token)match(input,18,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getDataTypeDefinitionRuleAccess().getColonKeyword_4_2());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:382:4: ( (lv_constraints_9_0= ruleStatementRule ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>=RULE_STRING && LA9_0<=RULE_ID)||LA9_0==28||LA9_0==32||LA9_0==34||LA9_0==37||(LA9_0>=40 && LA9_0<=41)||(LA9_0>=65 && LA9_0<=66)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:383:5: (lv_constraints_9_0= ruleStatementRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:383:5: (lv_constraints_9_0= ruleStatementRule )
                    	    // InternalDataDescriptionLanguage.g:384:6: lv_constraints_9_0= ruleStatementRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getDataTypeDefinitionRuleAccess().getConstraintsStatementRuleParserRuleCall_4_3_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_17);
                    	    lv_constraints_9_0=ruleStatementRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getDataTypeDefinitionRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"constraints",
                    	      							lv_constraints_9_0,
                    	      							"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.StatementRule");
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
                    break;

            }

            otherlv_10=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getDataTypeDefinitionRuleAccess().getSemicolonKeyword_5());
              		
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
    // $ANTLR end "ruleDataTypeDefinitionRule"


    // $ANTLR start "entryRuleDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:410:1: entryRuleDataDescriptionRule returns [EObject current=null] : iv_ruleDataDescriptionRule= ruleDataDescriptionRule EOF ;
    public final EObject entryRuleDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataDescriptionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:410:60: (iv_ruleDataDescriptionRule= ruleDataDescriptionRule EOF )
            // InternalDataDescriptionLanguage.g:411:2: iv_ruleDataDescriptionRule= ruleDataDescriptionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataDescriptionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDataDescriptionRule=ruleDataDescriptionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataDescriptionRule; 
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
    // $ANTLR end "entryRuleDataDescriptionRule"


    // $ANTLR start "ruleDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:417:1: ruleDataDescriptionRule returns [EObject current=null] : (this_TypedDataDescriptionRule_0= ruleTypedDataDescriptionRule | this_UntypedDataDescriptionRule_1= ruleUntypedDataDescriptionRule ) ;
    public final EObject ruleDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        EObject this_TypedDataDescriptionRule_0 = null;

        EObject this_UntypedDataDescriptionRule_1 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:423:2: ( (this_TypedDataDescriptionRule_0= ruleTypedDataDescriptionRule | this_UntypedDataDescriptionRule_1= ruleUntypedDataDescriptionRule ) )
            // InternalDataDescriptionLanguage.g:424:2: (this_TypedDataDescriptionRule_0= ruleTypedDataDescriptionRule | this_UntypedDataDescriptionRule_1= ruleUntypedDataDescriptionRule )
            {
            // InternalDataDescriptionLanguage.g:424:2: (this_TypedDataDescriptionRule_0= ruleTypedDataDescriptionRule | this_UntypedDataDescriptionRule_1= ruleUntypedDataDescriptionRule )
            int alt11=2;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:425:3: this_TypedDataDescriptionRule_0= ruleTypedDataDescriptionRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataDescriptionRuleAccess().getTypedDataDescriptionRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypedDataDescriptionRule_0=ruleTypedDataDescriptionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypedDataDescriptionRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:437:3: this_UntypedDataDescriptionRule_1= ruleUntypedDataDescriptionRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataDescriptionRuleAccess().getUntypedDataDescriptionRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_UntypedDataDescriptionRule_1=ruleUntypedDataDescriptionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UntypedDataDescriptionRule_1;
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
    // $ANTLR end "ruleDataDescriptionRule"


    // $ANTLR start "entryRuleTypedDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:452:1: entryRuleTypedDataDescriptionRule returns [EObject current=null] : iv_ruleTypedDataDescriptionRule= ruleTypedDataDescriptionRule EOF ;
    public final EObject entryRuleTypedDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedDataDescriptionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:452:65: (iv_ruleTypedDataDescriptionRule= ruleTypedDataDescriptionRule EOF )
            // InternalDataDescriptionLanguage.g:453:2: iv_ruleTypedDataDescriptionRule= ruleTypedDataDescriptionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedDataDescriptionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypedDataDescriptionRule=ruleTypedDataDescriptionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedDataDescriptionRule; 
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
    // $ANTLR end "entryRuleTypedDataDescriptionRule"


    // $ANTLR start "ruleTypedDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:459:1: ruleTypedDataDescriptionRule returns [EObject current=null] : ( ( (lv_representation_0_0= ruleRepresentationType ) ) otherlv_1= 'data' ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= 'of' otherlv_4= 'type' ( ( ruleQualifiedName ) ) (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';' ) ;
    public final EObject ruleTypedDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Enumerator lv_representation_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_constraints_9_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:465:2: ( ( ( (lv_representation_0_0= ruleRepresentationType ) ) otherlv_1= 'data' ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= 'of' otherlv_4= 'type' ( ( ruleQualifiedName ) ) (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';' ) )
            // InternalDataDescriptionLanguage.g:466:2: ( ( (lv_representation_0_0= ruleRepresentationType ) ) otherlv_1= 'data' ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= 'of' otherlv_4= 'type' ( ( ruleQualifiedName ) ) (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';' )
            {
            // InternalDataDescriptionLanguage.g:466:2: ( ( (lv_representation_0_0= ruleRepresentationType ) ) otherlv_1= 'data' ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= 'of' otherlv_4= 'type' ( ( ruleQualifiedName ) ) (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';' )
            // InternalDataDescriptionLanguage.g:467:3: ( (lv_representation_0_0= ruleRepresentationType ) ) otherlv_1= 'data' ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= 'of' otherlv_4= 'type' ( ( ruleQualifiedName ) ) (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';'
            {
            // InternalDataDescriptionLanguage.g:467:3: ( (lv_representation_0_0= ruleRepresentationType ) )
            // InternalDataDescriptionLanguage.g:468:4: (lv_representation_0_0= ruleRepresentationType )
            {
            // InternalDataDescriptionLanguage.g:468:4: (lv_representation_0_0= ruleRepresentationType )
            // InternalDataDescriptionLanguage.g:469:5: lv_representation_0_0= ruleRepresentationType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypedDataDescriptionRuleAccess().getRepresentationRepresentationTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_18);
            lv_representation_0_0=ruleRepresentationType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTypedDataDescriptionRuleRule());
              					}
              					set(
              						current,
              						"representation",
              						lv_representation_0_0,
              						"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.RepresentationType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getTypedDataDescriptionRuleAccess().getDataKeyword_1());
              		
            }
            // InternalDataDescriptionLanguage.g:490:3: ( (lv_name_2_0= ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:491:4: (lv_name_2_0= ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:491:4: (lv_name_2_0= ruleStringOrId )
            // InternalDataDescriptionLanguage.g:492:5: lv_name_2_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypedDataDescriptionRuleAccess().getNameStringOrIdParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_name_2_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTypedDataDescriptionRuleRule());
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

            otherlv_3=(Token)match(input,27,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getTypedDataDescriptionRuleAccess().getOfKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,24,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getTypedDataDescriptionRuleAccess().getTypeKeyword_4());
              		
            }
            // InternalDataDescriptionLanguage.g:517:3: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:518:4: ( ruleQualifiedName )
            {
            // InternalDataDescriptionLanguage.g:518:4: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:519:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTypedDataDescriptionRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypedDataDescriptionRuleAccess().getTypeDataTypeDefinitionCrossReference_5_0());
              				
            }
            pushFollow(FOLLOW_15);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalDataDescriptionLanguage.g:536:3: (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:537:4: otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )*
                    {
                    otherlv_6=(Token)match(input,26,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getTypedDataDescriptionRuleAccess().getWithKeyword_6_0());
                      			
                    }
                    otherlv_7=(Token)match(input,20,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getTypedDataDescriptionRuleAccess().getConstraintsKeyword_6_1());
                      			
                    }
                    otherlv_8=(Token)match(input,18,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getTypedDataDescriptionRuleAccess().getColonKeyword_6_2());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:549:4: ( (lv_constraints_9_0= ruleStatementRule ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=RULE_STRING && LA12_0<=RULE_ID)||LA12_0==28||LA12_0==32||LA12_0==34||LA12_0==37||(LA12_0>=40 && LA12_0<=41)||(LA12_0>=65 && LA12_0<=66)) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:550:5: (lv_constraints_9_0= ruleStatementRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:550:5: (lv_constraints_9_0= ruleStatementRule )
                    	    // InternalDataDescriptionLanguage.g:551:6: lv_constraints_9_0= ruleStatementRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getTypedDataDescriptionRuleAccess().getConstraintsStatementRuleParserRuleCall_6_3_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_17);
                    	    lv_constraints_9_0=ruleStatementRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getTypedDataDescriptionRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"constraints",
                    	      							lv_constraints_9_0,
                    	      							"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.StatementRule");
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
                    break;

            }

            otherlv_10=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getTypedDataDescriptionRuleAccess().getSemicolonKeyword_7());
              		
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
    // $ANTLR end "ruleTypedDataDescriptionRule"


    // $ANTLR start "entryRuleUntypedDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:577:1: entryRuleUntypedDataDescriptionRule returns [EObject current=null] : iv_ruleUntypedDataDescriptionRule= ruleUntypedDataDescriptionRule EOF ;
    public final EObject entryRuleUntypedDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUntypedDataDescriptionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:577:67: (iv_ruleUntypedDataDescriptionRule= ruleUntypedDataDescriptionRule EOF )
            // InternalDataDescriptionLanguage.g:578:2: iv_ruleUntypedDataDescriptionRule= ruleUntypedDataDescriptionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUntypedDataDescriptionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUntypedDataDescriptionRule=ruleUntypedDataDescriptionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUntypedDataDescriptionRule; 
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
    // $ANTLR end "entryRuleUntypedDataDescriptionRule"


    // $ANTLR start "ruleUntypedDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:584:1: ruleUntypedDataDescriptionRule returns [EObject current=null] : ( ( (lv_scale_0_0= ruleScaleType ) )? ( (lv_representation_1_0= ruleRepresentationType ) ) otherlv_2= 'data' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'with' otherlv_5= 'constraints' otherlv_6= ':' ( (lv_constraints_7_0= ruleStatementRule ) )* )? otherlv_8= ';' ) ;
    public final EObject ruleUntypedDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Enumerator lv_scale_0_0 = null;

        Enumerator lv_representation_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_constraints_7_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:590:2: ( ( ( (lv_scale_0_0= ruleScaleType ) )? ( (lv_representation_1_0= ruleRepresentationType ) ) otherlv_2= 'data' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'with' otherlv_5= 'constraints' otherlv_6= ':' ( (lv_constraints_7_0= ruleStatementRule ) )* )? otherlv_8= ';' ) )
            // InternalDataDescriptionLanguage.g:591:2: ( ( (lv_scale_0_0= ruleScaleType ) )? ( (lv_representation_1_0= ruleRepresentationType ) ) otherlv_2= 'data' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'with' otherlv_5= 'constraints' otherlv_6= ':' ( (lv_constraints_7_0= ruleStatementRule ) )* )? otherlv_8= ';' )
            {
            // InternalDataDescriptionLanguage.g:591:2: ( ( (lv_scale_0_0= ruleScaleType ) )? ( (lv_representation_1_0= ruleRepresentationType ) ) otherlv_2= 'data' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'with' otherlv_5= 'constraints' otherlv_6= ':' ( (lv_constraints_7_0= ruleStatementRule ) )* )? otherlv_8= ';' )
            // InternalDataDescriptionLanguage.g:592:3: ( (lv_scale_0_0= ruleScaleType ) )? ( (lv_representation_1_0= ruleRepresentationType ) ) otherlv_2= 'data' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'with' otherlv_5= 'constraints' otherlv_6= ':' ( (lv_constraints_7_0= ruleStatementRule ) )* )? otherlv_8= ';'
            {
            // InternalDataDescriptionLanguage.g:592:3: ( (lv_scale_0_0= ruleScaleType ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=53 && LA14_0<=56)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:593:4: (lv_scale_0_0= ruleScaleType )
                    {
                    // InternalDataDescriptionLanguage.g:593:4: (lv_scale_0_0= ruleScaleType )
                    // InternalDataDescriptionLanguage.g:594:5: lv_scale_0_0= ruleScaleType
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getUntypedDataDescriptionRuleAccess().getScaleScaleTypeEnumRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_20);
                    lv_scale_0_0=ruleScaleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getUntypedDataDescriptionRuleRule());
                      					}
                      					set(
                      						current,
                      						"scale",
                      						lv_scale_0_0,
                      						"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.ScaleType");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalDataDescriptionLanguage.g:611:3: ( (lv_representation_1_0= ruleRepresentationType ) )
            // InternalDataDescriptionLanguage.g:612:4: (lv_representation_1_0= ruleRepresentationType )
            {
            // InternalDataDescriptionLanguage.g:612:4: (lv_representation_1_0= ruleRepresentationType )
            // InternalDataDescriptionLanguage.g:613:5: lv_representation_1_0= ruleRepresentationType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUntypedDataDescriptionRuleAccess().getRepresentationRepresentationTypeEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_18);
            lv_representation_1_0=ruleRepresentationType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUntypedDataDescriptionRuleRule());
              					}
              					set(
              						current,
              						"representation",
              						lv_representation_1_0,
              						"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.RepresentationType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getUntypedDataDescriptionRuleAccess().getDataKeyword_2());
              		
            }
            // InternalDataDescriptionLanguage.g:634:3: ( (lv_name_3_0= ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:635:4: (lv_name_3_0= ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:635:4: (lv_name_3_0= ruleStringOrId )
            // InternalDataDescriptionLanguage.g:636:5: lv_name_3_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUntypedDataDescriptionRuleAccess().getNameStringOrIdParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_name_3_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUntypedDataDescriptionRuleRule());
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

            // InternalDataDescriptionLanguage.g:653:3: (otherlv_4= 'with' otherlv_5= 'constraints' otherlv_6= ':' ( (lv_constraints_7_0= ruleStatementRule ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:654:4: otherlv_4= 'with' otherlv_5= 'constraints' otherlv_6= ':' ( (lv_constraints_7_0= ruleStatementRule ) )*
                    {
                    otherlv_4=(Token)match(input,26,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getUntypedDataDescriptionRuleAccess().getWithKeyword_4_0());
                      			
                    }
                    otherlv_5=(Token)match(input,20,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getUntypedDataDescriptionRuleAccess().getConstraintsKeyword_4_1());
                      			
                    }
                    otherlv_6=(Token)match(input,18,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getUntypedDataDescriptionRuleAccess().getColonKeyword_4_2());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:666:4: ( (lv_constraints_7_0= ruleStatementRule ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>=RULE_STRING && LA15_0<=RULE_ID)||LA15_0==28||LA15_0==32||LA15_0==34||LA15_0==37||(LA15_0>=40 && LA15_0<=41)||(LA15_0>=65 && LA15_0<=66)) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:667:5: (lv_constraints_7_0= ruleStatementRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:667:5: (lv_constraints_7_0= ruleStatementRule )
                    	    // InternalDataDescriptionLanguage.g:668:6: lv_constraints_7_0= ruleStatementRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getUntypedDataDescriptionRuleAccess().getConstraintsStatementRuleParserRuleCall_4_3_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_17);
                    	    lv_constraints_7_0=ruleStatementRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getUntypedDataDescriptionRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"constraints",
                    	      							lv_constraints_7_0,
                    	      							"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.StatementRule");
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
                    break;

            }

            otherlv_8=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getUntypedDataDescriptionRuleAccess().getSemicolonKeyword_5());
              		
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
    // $ANTLR end "ruleUntypedDataDescriptionRule"


    // $ANTLR start "entryRuleStatementRule"
    // InternalDataDescriptionLanguage.g:694:1: entryRuleStatementRule returns [EObject current=null] : iv_ruleStatementRule= ruleStatementRule EOF ;
    public final EObject entryRuleStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementRule = null;


        try {
            // InternalDataDescriptionLanguage.g:694:54: (iv_ruleStatementRule= ruleStatementRule EOF )
            // InternalDataDescriptionLanguage.g:695:2: iv_ruleStatementRule= ruleStatementRule EOF
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
    // InternalDataDescriptionLanguage.g:701:1: ruleStatementRule returns [EObject current=null] : (this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';' ) ;
    public final EObject ruleStatementRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_ExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:707:2: ( (this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';' ) )
            // InternalDataDescriptionLanguage.g:708:2: (this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';' )
            {
            // InternalDataDescriptionLanguage.g:708:2: (this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';' )
            // InternalDataDescriptionLanguage.g:709:3: this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';'
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getStatementRuleAccess().getExpressionRuleParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_11);
            this_ExpressionRule_0=ruleExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ExpressionRule_0;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_1=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleReferenceRule"
    // InternalDataDescriptionLanguage.g:728:1: entryRuleReferenceRule returns [EObject current=null] : iv_ruleReferenceRule= ruleReferenceRule EOF ;
    public final EObject entryRuleReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceRule = null;


        try {
            // InternalDataDescriptionLanguage.g:728:54: (iv_ruleReferenceRule= ruleReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:729:2: iv_ruleReferenceRule= ruleReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:735:1: ruleReferenceRule returns [EObject current=null] : (this_ConstantReferenceRule_0= ruleConstantReferenceRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_SelfReferenceRule_2= ruleSelfReferenceRule ) ;
    public final EObject ruleReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_ConstantReferenceRule_0 = null;

        EObject this_DataReferenceRule_1 = null;

        EObject this_SelfReferenceRule_2 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:741:2: ( (this_ConstantReferenceRule_0= ruleConstantReferenceRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_SelfReferenceRule_2= ruleSelfReferenceRule ) )
            // InternalDataDescriptionLanguage.g:742:2: (this_ConstantReferenceRule_0= ruleConstantReferenceRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_SelfReferenceRule_2= ruleSelfReferenceRule )
            {
            // InternalDataDescriptionLanguage.g:742:2: (this_ConstantReferenceRule_0= ruleConstantReferenceRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_SelfReferenceRule_2= ruleSelfReferenceRule )
            int alt17=3;
            switch ( input.LA(1) ) {
            case RULE_QUOTED_ID:
                {
                int LA17_1 = input.LA(2);

                if ( (synpred17_InternalDataDescriptionLanguage()) ) {
                    alt17=1;
                }
                else if ( (synpred18_InternalDataDescriptionLanguage()) ) {
                    alt17=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA17_2 = input.LA(2);

                if ( (synpred17_InternalDataDescriptionLanguage()) ) {
                    alt17=1;
                }
                else if ( (synpred18_InternalDataDescriptionLanguage()) ) {
                    alt17=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 2, input);

                    throw nvae;
                }
                }
                break;
            case 28:
                {
                alt17=3;
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
                    // InternalDataDescriptionLanguage.g:743:3: this_ConstantReferenceRule_0= ruleConstantReferenceRule
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
                    // InternalDataDescriptionLanguage.g:755:3: this_DataReferenceRule_1= ruleDataReferenceRule
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
                    // InternalDataDescriptionLanguage.g:767:3: this_SelfReferenceRule_2= ruleSelfReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReferenceRuleAccess().getSelfReferenceRuleParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SelfReferenceRule_2=ruleSelfReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SelfReferenceRule_2;
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
    // InternalDataDescriptionLanguage.g:782:1: entryRuleDataReferenceRule returns [EObject current=null] : iv_ruleDataReferenceRule= ruleDataReferenceRule EOF ;
    public final EObject entryRuleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataReferenceRule = null;


        try {
            // InternalDataDescriptionLanguage.g:782:58: (iv_ruleDataReferenceRule= ruleDataReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:783:2: iv_ruleDataReferenceRule= ruleDataReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:789:1: ruleDataReferenceRule returns [EObject current=null] : ( ( ruleStringOrId ) ) ;
    public final EObject ruleDataReferenceRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:795:2: ( ( ( ruleStringOrId ) ) )
            // InternalDataDescriptionLanguage.g:796:2: ( ( ruleStringOrId ) )
            {
            // InternalDataDescriptionLanguage.g:796:2: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:797:3: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:797:3: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:798:4: ruleStringOrId
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

              				newCompositeNode(grammarAccess.getDataReferenceRuleAccess().getDefinitionDataDescriptionCrossReference_0());
              			
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
    // $ANTLR end "ruleDataReferenceRule"


    // $ANTLR start "entryRuleSelfReferenceRule"
    // InternalDataDescriptionLanguage.g:818:1: entryRuleSelfReferenceRule returns [EObject current=null] : iv_ruleSelfReferenceRule= ruleSelfReferenceRule EOF ;
    public final EObject entryRuleSelfReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfReferenceRule = null;


        try {
            // InternalDataDescriptionLanguage.g:818:58: (iv_ruleSelfReferenceRule= ruleSelfReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:819:2: iv_ruleSelfReferenceRule= ruleSelfReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:825:1: ruleSelfReferenceRule returns [EObject current=null] : ( () otherlv_1= 'value' ) ;
    public final EObject ruleSelfReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:831:2: ( ( () otherlv_1= 'value' ) )
            // InternalDataDescriptionLanguage.g:832:2: ( () otherlv_1= 'value' )
            {
            // InternalDataDescriptionLanguage.g:832:2: ( () otherlv_1= 'value' )
            // InternalDataDescriptionLanguage.g:833:3: () otherlv_1= 'value'
            {
            // InternalDataDescriptionLanguage.g:833:3: ()
            // InternalDataDescriptionLanguage.g:834:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSelfReferenceRuleAccess().getValueKeyword_1());
              		
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
    // $ANTLR end "ruleSelfReferenceRule"


    // $ANTLR start "entryRuleExpressionRule"
    // InternalDataDescriptionLanguage.g:851:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:851:55: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:852:2: iv_ruleExpressionRule= ruleExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:858:1: ruleExpressionRule returns [EObject current=null] : this_OrExpressionRule_0= ruleOrExpressionRule ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:864:2: (this_OrExpressionRule_0= ruleOrExpressionRule )
            // InternalDataDescriptionLanguage.g:865:2: this_OrExpressionRule_0= ruleOrExpressionRule
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
    // InternalDataDescriptionLanguage.g:879:1: entryRuleOrExpressionRule returns [EObject current=null] : iv_ruleOrExpressionRule= ruleOrExpressionRule EOF ;
    public final EObject entryRuleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:879:57: (iv_ruleOrExpressionRule= ruleOrExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:880:2: iv_ruleOrExpressionRule= ruleOrExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:886:1: ruleOrExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) ;
    public final EObject ruleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:892:2: ( ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) )
            // InternalDataDescriptionLanguage.g:893:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            {
            // InternalDataDescriptionLanguage.g:893:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            // InternalDataDescriptionLanguage.g:894:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            {
            // InternalDataDescriptionLanguage.g:894:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) )
            // InternalDataDescriptionLanguage.g:895:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:895:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            // InternalDataDescriptionLanguage.g:896:5: lv_subExpressions_0_0= ruleXorExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_21);
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

            // InternalDataDescriptionLanguage.g:913:3: (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==29) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:914:4: otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,29,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0());
            	      			
            	    }
            	    // InternalDataDescriptionLanguage.g:918:4: ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    // InternalDataDescriptionLanguage.g:919:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:919:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    // InternalDataDescriptionLanguage.g:920:6: lv_subExpressions_2_0= ruleXorExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_21);
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
    // $ANTLR end "ruleOrExpressionRule"


    // $ANTLR start "entryRuleXorExpressionRule"
    // InternalDataDescriptionLanguage.g:942:1: entryRuleXorExpressionRule returns [EObject current=null] : iv_ruleXorExpressionRule= ruleXorExpressionRule EOF ;
    public final EObject entryRuleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:942:58: (iv_ruleXorExpressionRule= ruleXorExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:943:2: iv_ruleXorExpressionRule= ruleXorExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:949:1: ruleXorExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) ;
    public final EObject ruleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:955:2: ( ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) )
            // InternalDataDescriptionLanguage.g:956:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            {
            // InternalDataDescriptionLanguage.g:956:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            // InternalDataDescriptionLanguage.g:957:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            {
            // InternalDataDescriptionLanguage.g:957:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) )
            // InternalDataDescriptionLanguage.g:958:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:958:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            // InternalDataDescriptionLanguage.g:959:5: lv_subExpressions_0_0= ruleAndExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_23);
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

            // InternalDataDescriptionLanguage.g:976:3: (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==30) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:977:4: otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,30,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0());
            	      			
            	    }
            	    // InternalDataDescriptionLanguage.g:981:4: ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    // InternalDataDescriptionLanguage.g:982:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:982:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    // InternalDataDescriptionLanguage.g:983:6: lv_subExpressions_2_0= ruleAndExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_23);
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
            	    break loop19;
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
    // InternalDataDescriptionLanguage.g:1005:1: entryRuleAndExpressionRule returns [EObject current=null] : iv_ruleAndExpressionRule= ruleAndExpressionRule EOF ;
    public final EObject entryRuleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1005:58: (iv_ruleAndExpressionRule= ruleAndExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1006:2: iv_ruleAndExpressionRule= ruleAndExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1012:1: ruleAndExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) ;
    public final EObject ruleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1018:2: ( ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) )
            // InternalDataDescriptionLanguage.g:1019:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            {
            // InternalDataDescriptionLanguage.g:1019:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            // InternalDataDescriptionLanguage.g:1020:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            {
            // InternalDataDescriptionLanguage.g:1020:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1021:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1021:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            // InternalDataDescriptionLanguage.g:1022:5: lv_subExpressions_0_0= ruleNotExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_24);
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

            // InternalDataDescriptionLanguage.g:1039:3: (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==31) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1040:4: otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,31,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0());
            	      			
            	    }
            	    // InternalDataDescriptionLanguage.g:1044:4: ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    // InternalDataDescriptionLanguage.g:1045:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1045:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    // InternalDataDescriptionLanguage.g:1046:6: lv_subExpressions_2_0= ruleNotExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_24);
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
    // $ANTLR end "ruleAndExpressionRule"


    // $ANTLR start "entryRuleNotExpressionRule"
    // InternalDataDescriptionLanguage.g:1068:1: entryRuleNotExpressionRule returns [EObject current=null] : iv_ruleNotExpressionRule= ruleNotExpressionRule EOF ;
    public final EObject entryRuleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1068:58: (iv_ruleNotExpressionRule= ruleNotExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1069:2: iv_ruleNotExpressionRule= ruleNotExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1075:1: ruleNotExpressionRule returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) ;
    public final EObject ruleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1081:2: ( ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) )
            // InternalDataDescriptionLanguage.g:1082:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            {
            // InternalDataDescriptionLanguage.g:1082:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            // InternalDataDescriptionLanguage.g:1083:3: ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            {
            // InternalDataDescriptionLanguage.g:1083:3: ( (lv_negated_0_0= '!' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==32) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1084:4: (lv_negated_0_0= '!' )
                    {
                    // InternalDataDescriptionLanguage.g:1084:4: (lv_negated_0_0= '!' )
                    // InternalDataDescriptionLanguage.g:1085:5: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,32,FOLLOW_22); if (state.failed) return current;
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

            // InternalDataDescriptionLanguage.g:1097:3: ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1098:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1098:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            // InternalDataDescriptionLanguage.g:1099:5: lv_operand_1_0= ruleComparisonExpressionRule
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
    // InternalDataDescriptionLanguage.g:1120:1: entryRuleComparisonExpressionRule returns [EObject current=null] : iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF ;
    public final EObject entryRuleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1120:65: (iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1121:2: iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1127:1: ruleComparisonExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) ;
    public final EObject ruleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        EObject lv_comparison_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1133:2: ( ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) )
            // InternalDataDescriptionLanguage.g:1134:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            {
            // InternalDataDescriptionLanguage.g:1134:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            // InternalDataDescriptionLanguage.g:1135:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            {
            // InternalDataDescriptionLanguage.g:1135:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1136:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1136:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:1137:5: lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_25);
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

            // InternalDataDescriptionLanguage.g:1154:3: ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=59 && LA22_0<=64)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1155:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1155:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    // InternalDataDescriptionLanguage.g:1156:5: lv_comparison_1_0= rulePartialComparisonExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_25);
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
    // $ANTLR end "ruleComparisonExpressionRule"


    // $ANTLR start "entryRulePartialComparisonExpressionRule"
    // InternalDataDescriptionLanguage.g:1177:1: entryRulePartialComparisonExpressionRule returns [EObject current=null] : iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF ;
    public final EObject entryRulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialComparisonExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1177:72: (iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1178:2: iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1184:1: rulePartialComparisonExpressionRule returns [EObject current=null] : ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) ;
    public final EObject rulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1190:2: ( ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) )
            // InternalDataDescriptionLanguage.g:1191:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            {
            // InternalDataDescriptionLanguage.g:1191:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            // InternalDataDescriptionLanguage.g:1192:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            {
            // InternalDataDescriptionLanguage.g:1192:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) )
            // InternalDataDescriptionLanguage.g:1193:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:1193:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            // InternalDataDescriptionLanguage.g:1194:5: lv_operator_0_0= ruleComparisonOperatorRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_22);
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

            // InternalDataDescriptionLanguage.g:1211:3: ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1212:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1212:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:1213:5: lv_subExpression_1_0= ruleAddOrSubtractExpressionRule
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
    // InternalDataDescriptionLanguage.g:1234:1: entryRuleAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOrSubtractExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1234:68: (iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1235:2: iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1241:1: ruleAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) ;
    public final EObject ruleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1247:2: ( ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) )
            // InternalDataDescriptionLanguage.g:1248:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            {
            // InternalDataDescriptionLanguage.g:1248:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            // InternalDataDescriptionLanguage.g:1249:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            {
            // InternalDataDescriptionLanguage.g:1249:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1250:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1250:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            // InternalDataDescriptionLanguage.g:1251:5: lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_26);
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

            // InternalDataDescriptionLanguage.g:1268:3: ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=65 && LA23_0<=66)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1269:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    {
            	    // InternalDataDescriptionLanguage.g:1269:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) )
            	    // InternalDataDescriptionLanguage.g:1270:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1270:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    // InternalDataDescriptionLanguage.g:1271:6: lv_operators_1_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_22);
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

            	    // InternalDataDescriptionLanguage.g:1288:4: ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    // InternalDataDescriptionLanguage.g:1289:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1289:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    // InternalDataDescriptionLanguage.g:1290:6: lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_26);
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
    // $ANTLR end "ruleAddOrSubtractExpressionRule"


    // $ANTLR start "entryRuleMultiplyDivideModuloExpressionRule"
    // InternalDataDescriptionLanguage.g:1312:1: entryRuleMultiplyDivideModuloExpressionRule returns [EObject current=null] : iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF ;
    public final EObject entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideModuloExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1312:75: (iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1313:2: iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1319:1: ruleMultiplyDivideModuloExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) ;
    public final EObject ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1325:2: ( ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) )
            // InternalDataDescriptionLanguage.g:1326:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            {
            // InternalDataDescriptionLanguage.g:1326:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            // InternalDataDescriptionLanguage.g:1327:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            {
            // InternalDataDescriptionLanguage.g:1327:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1328:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1328:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            // InternalDataDescriptionLanguage.g:1329:5: lv_leftOperand_0_0= rulePowerOfExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_27);
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

            // InternalDataDescriptionLanguage.g:1346:3: ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=67 && LA24_0<=69)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1347:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    {
            	    // InternalDataDescriptionLanguage.g:1347:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) )
            	    // InternalDataDescriptionLanguage.g:1348:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1348:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    // InternalDataDescriptionLanguage.g:1349:6: lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_22);
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

            	    // InternalDataDescriptionLanguage.g:1366:4: ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    // InternalDataDescriptionLanguage.g:1367:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1367:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    // InternalDataDescriptionLanguage.g:1368:6: lv_operands_2_0= rulePowerOfExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_27);
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
    // $ANTLR end "ruleMultiplyDivideModuloExpressionRule"


    // $ANTLR start "entryRulePowerOfExpressionRule"
    // InternalDataDescriptionLanguage.g:1390:1: entryRulePowerOfExpressionRule returns [EObject current=null] : iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF ;
    public final EObject entryRulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerOfExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1390:62: (iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1391:2: iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1397:1: rulePowerOfExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) ;
    public final EObject rulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_leftOperand_0_0 = null;

        EObject lv_rightOperand_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1403:2: ( ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) )
            // InternalDataDescriptionLanguage.g:1404:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            {
            // InternalDataDescriptionLanguage.g:1404:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            // InternalDataDescriptionLanguage.g:1405:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            {
            // InternalDataDescriptionLanguage.g:1405:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1406:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1406:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:1407:5: lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_28);
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

            // InternalDataDescriptionLanguage.g:1424:3: (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==33) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1425:4: otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:1429:4: ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    // InternalDataDescriptionLanguage.g:1430:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    {
                    // InternalDataDescriptionLanguage.g:1430:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    // InternalDataDescriptionLanguage.g:1431:6: lv_rightOperand_2_0= rulePowerOfExpressionRule
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
    // InternalDataDescriptionLanguage.g:1453:1: entryRuleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryAddOrSubtractExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1453:73: (iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1454:2: iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1460:1: ruleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) ) ) ;
    public final EObject ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operators_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1466:2: ( ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) ) ) )
            // InternalDataDescriptionLanguage.g:1467:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) ) )
            {
            // InternalDataDescriptionLanguage.g:1467:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) ) )
            // InternalDataDescriptionLanguage.g:1468:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) )
            {
            // InternalDataDescriptionLanguage.g:1468:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=65 && LA26_0<=66)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1469:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1469:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    // InternalDataDescriptionLanguage.g:1470:5: lv_operators_0_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_22);
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
            	    break loop26;
                }
            } while (true);

            // InternalDataDescriptionLanguage.g:1487:3: ( (lv_subExpression_1_0= ruleValueRule ) )
            // InternalDataDescriptionLanguage.g:1488:4: (lv_subExpression_1_0= ruleValueRule )
            {
            // InternalDataDescriptionLanguage.g:1488:4: (lv_subExpression_1_0= ruleValueRule )
            // InternalDataDescriptionLanguage.g:1489:5: lv_subExpression_1_0= ruleValueRule
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
    // InternalDataDescriptionLanguage.g:1510:1: entryRuleValueRule returns [EObject current=null] : iv_ruleValueRule= ruleValueRule EOF ;
    public final EObject entryRuleValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1510:50: (iv_ruleValueRule= ruleValueRule EOF )
            // InternalDataDescriptionLanguage.g:1511:2: iv_ruleValueRule= ruleValueRule EOF
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
    // InternalDataDescriptionLanguage.g:1517:1: ruleValueRule returns [EObject current=null] : (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule ) ;
    public final EObject ruleValueRule() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayRule_0 = null;

        EObject this_CallRule_1 = null;

        EObject this_LiteralRule_2 = null;

        EObject this_ParanthesesRule_3 = null;

        EObject this_ReferenceRule_4 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1523:2: ( (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule ) )
            // InternalDataDescriptionLanguage.g:1524:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )
            {
            // InternalDataDescriptionLanguage.g:1524:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )
            int alt27=5;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt27=1;
                }
                break;
            case RULE_QUOTED_ID:
                {
                int LA27_2 = input.LA(2);

                if ( (LA27_2==37||LA27_2==52) ) {
                    alt27=2;
                }
                else if ( (synpred30_InternalDataDescriptionLanguage()) ) {
                    alt27=3;
                }
                else if ( (true) ) {
                    alt27=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA27_3 = input.LA(2);

                if ( (LA27_3==37||LA27_3==52) ) {
                    alt27=2;
                }
                else if ( (synpred30_InternalDataDescriptionLanguage()) ) {
                    alt27=3;
                }
                else if ( (true) ) {
                    alt27=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case RULE_DOUBLE:
            case RULE_INT:
            case 40:
            case 41:
                {
                alt27=3;
                }
                break;
            case 37:
                {
                alt27=4;
                }
                break;
            case 28:
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
                    // InternalDataDescriptionLanguage.g:1525:3: this_ArrayRule_0= ruleArrayRule
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
                    // InternalDataDescriptionLanguage.g:1537:3: this_CallRule_1= ruleCallRule
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
                    // InternalDataDescriptionLanguage.g:1549:3: this_LiteralRule_2= ruleLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1561:3: this_ParanthesesRule_3= ruleParanthesesRule
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
                    // InternalDataDescriptionLanguage.g:1573:3: this_ReferenceRule_4= ruleReferenceRule
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
    // InternalDataDescriptionLanguage.g:1588:1: entryRuleArrayRule returns [EObject current=null] : iv_ruleArrayRule= ruleArrayRule EOF ;
    public final EObject entryRuleArrayRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1588:50: (iv_ruleArrayRule= ruleArrayRule EOF )
            // InternalDataDescriptionLanguage.g:1589:2: iv_ruleArrayRule= ruleArrayRule EOF
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
    // InternalDataDescriptionLanguage.g:1595:1: ruleArrayRule returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1601:2: ( ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) )
            // InternalDataDescriptionLanguage.g:1602:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            {
            // InternalDataDescriptionLanguage.g:1602:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            // InternalDataDescriptionLanguage.g:1603:3: () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']'
            {
            // InternalDataDescriptionLanguage.g:1603:3: ()
            // InternalDataDescriptionLanguage.g:1604:4: 
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

            otherlv_1=(Token)match(input,34,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalDataDescriptionLanguage.g:1617:3: ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_STRING && LA29_0<=RULE_ID)||LA29_0==28||LA29_0==34||LA29_0==37||(LA29_0>=40 && LA29_0<=41)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1618:4: ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    {
                    // InternalDataDescriptionLanguage.g:1618:4: ( (lv_values_2_0= ruleValueRule ) )
                    // InternalDataDescriptionLanguage.g:1619:5: (lv_values_2_0= ruleValueRule )
                    {
                    // InternalDataDescriptionLanguage.g:1619:5: (lv_values_2_0= ruleValueRule )
                    // InternalDataDescriptionLanguage.g:1620:6: lv_values_2_0= ruleValueRule
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

                    // InternalDataDescriptionLanguage.g:1637:4: (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==35) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:1638:5: otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,35,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalDataDescriptionLanguage.g:1642:5: ( (lv_values_4_0= ruleValueRule ) )
                    	    // InternalDataDescriptionLanguage.g:1643:6: (lv_values_4_0= ruleValueRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:1643:6: (lv_values_4_0= ruleValueRule )
                    	    // InternalDataDescriptionLanguage.g:1644:7: lv_values_4_0= ruleValueRule
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
                    	    break loop28;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:1671:1: entryRuleParanthesesRule returns [EObject current=null] : iv_ruleParanthesesRule= ruleParanthesesRule EOF ;
    public final EObject entryRuleParanthesesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesesRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1671:56: (iv_ruleParanthesesRule= ruleParanthesesRule EOF )
            // InternalDataDescriptionLanguage.g:1672:2: iv_ruleParanthesesRule= ruleParanthesesRule EOF
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
    // InternalDataDescriptionLanguage.g:1678:1: ruleParanthesesRule returns [EObject current=null] : (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) ;
    public final EObject ruleParanthesesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1684:2: ( (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) )
            // InternalDataDescriptionLanguage.g:1685:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            {
            // InternalDataDescriptionLanguage.g:1685:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            // InternalDataDescriptionLanguage.g:1686:3: otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalDataDescriptionLanguage.g:1690:3: ( (lv_subExpression_1_0= ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1691:4: (lv_subExpression_1_0= ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1691:4: (lv_subExpression_1_0= ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:1692:5: lv_subExpression_1_0= ruleExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_31);
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

            otherlv_2=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:1717:1: entryRuleCallRule returns [EObject current=null] : iv_ruleCallRule= ruleCallRule EOF ;
    public final EObject entryRuleCallRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1717:49: (iv_ruleCallRule= ruleCallRule EOF )
            // InternalDataDescriptionLanguage.g:1718:2: iv_ruleCallRule= ruleCallRule EOF
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
    // InternalDataDescriptionLanguage.g:1724:1: ruleCallRule returns [EObject current=null] : ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) ;
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
            // InternalDataDescriptionLanguage.g:1730:2: ( ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) )
            // InternalDataDescriptionLanguage.g:1731:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            {
            // InternalDataDescriptionLanguage.g:1731:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            // InternalDataDescriptionLanguage.g:1732:3: ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')'
            {
            // InternalDataDescriptionLanguage.g:1732:3: ( (lv_function_0_0= ruleFunctionNameRule ) )
            // InternalDataDescriptionLanguage.g:1733:4: (lv_function_0_0= ruleFunctionNameRule )
            {
            // InternalDataDescriptionLanguage.g:1733:4: (lv_function_0_0= ruleFunctionNameRule )
            // InternalDataDescriptionLanguage.g:1734:5: lv_function_0_0= ruleFunctionNameRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCallRuleAccess().getFunctionFunctionNameRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_32);
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

            otherlv_1=(Token)match(input,37,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalDataDescriptionLanguage.g:1755:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_STRING && LA31_0<=RULE_ID)||LA31_0==28||LA31_0==32||LA31_0==34||LA31_0==37||(LA31_0>=40 && LA31_0<=41)||(LA31_0>=65 && LA31_0<=66)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1756:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalDataDescriptionLanguage.g:1756:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalDataDescriptionLanguage.g:1757:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalDataDescriptionLanguage.g:1757:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalDataDescriptionLanguage.g:1758:6: lv_parameters_2_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_34);
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

                    // InternalDataDescriptionLanguage.g:1775:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==35) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:1776:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,35,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalDataDescriptionLanguage.g:1780:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalDataDescriptionLanguage.g:1781:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:1781:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalDataDescriptionLanguage.g:1782:7: lv_parameters_4_0= ruleExpressionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_34);
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
                    	    break loop30;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:1809:1: entryRuleConstantReferenceRule returns [EObject current=null] : iv_ruleConstantReferenceRule= ruleConstantReferenceRule EOF ;
    public final EObject entryRuleConstantReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantReferenceRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1809:62: (iv_ruleConstantReferenceRule= ruleConstantReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:1810:2: iv_ruleConstantReferenceRule= ruleConstantReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:1816:1: ruleConstantReferenceRule returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleConstantReferenceRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1822:2: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDescriptionLanguage.g:1823:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDescriptionLanguage.g:1823:2: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:1824:3: ( ruleQualifiedName )
            {
            // InternalDataDescriptionLanguage.g:1824:3: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:1825:4: ruleQualifiedName
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
    // InternalDataDescriptionLanguage.g:1845:1: entryRuleLiteralRule returns [EObject current=null] : iv_ruleLiteralRule= ruleLiteralRule EOF ;
    public final EObject entryRuleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1845:52: (iv_ruleLiteralRule= ruleLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:1846:2: iv_ruleLiteralRule= ruleLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:1852:1: ruleLiteralRule returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule ) ;
    public final EObject ruleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_StringLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;

        EObject this_InstanceLiteralRule_3 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1858:2: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule ) )
            // InternalDataDescriptionLanguage.g:1859:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule )
            {
            // InternalDataDescriptionLanguage.g:1859:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule )
            int alt32=4;
            switch ( input.LA(1) ) {
            case RULE_DOUBLE:
            case RULE_INT:
                {
                alt32=1;
                }
                break;
            case RULE_STRING:
                {
                alt32=2;
                }
                break;
            case 40:
            case 41:
                {
                alt32=3;
                }
                break;
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt32=4;
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
                    // InternalDataDescriptionLanguage.g:1860:3: this_NumberLiteralRule_0= ruleNumberLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1872:3: this_StringLiteralRule_1= ruleStringLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1884:3: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1896:3: this_InstanceLiteralRule_3= ruleInstanceLiteralRule
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
    // InternalDataDescriptionLanguage.g:1911:1: entryRuleInstanceLiteralRule returns [EObject current=null] : iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF ;
    public final EObject entryRuleInstanceLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1911:60: (iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:1912:2: iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:1918:1: ruleInstanceLiteralRule returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? ) ;
    public final EObject ruleInstanceLiteralRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1924:2: ( ( ( ( ruleQualifiedName ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? ) )
            // InternalDataDescriptionLanguage.g:1925:2: ( ( ( ruleQualifiedName ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? )
            {
            // InternalDataDescriptionLanguage.g:1925:2: ( ( ( ruleQualifiedName ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )? )
            // InternalDataDescriptionLanguage.g:1926:3: ( ( ruleQualifiedName ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )?
            {
            // InternalDataDescriptionLanguage.g:1926:3: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:1927:4: ( ruleQualifiedName )
            {
            // InternalDataDescriptionLanguage.g:1927:4: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:1928:5: ruleQualifiedName
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
            pushFollow(FOLLOW_35);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalDataDescriptionLanguage.g:1945:3: (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==16) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1946:4: otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getInstanceLiteralRuleAccess().getLeftCurlyBracketKeyword_1_0());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:1950:4: ( (lv_attributes_2_0= ruleAttributeRule ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( ((LA33_0>=RULE_QUOTED_ID && LA33_0<=RULE_ID)) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:1951:5: (lv_attributes_2_0= ruleAttributeRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:1951:5: (lv_attributes_2_0= ruleAttributeRule )
                    	    // InternalDataDescriptionLanguage.g:1952:6: lv_attributes_2_0= ruleAttributeRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getInstanceLiteralRuleAccess().getAttributesAttributeRuleParserRuleCall_1_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_36);
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
                    	    break loop33;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getInstanceLiteralRuleAccess().getRightCurlyBracketKeyword_1_2());
                      			
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
    // $ANTLR end "ruleInstanceLiteralRule"


    // $ANTLR start "entryRuleAttributeRule"
    // InternalDataDescriptionLanguage.g:1978:1: entryRuleAttributeRule returns [EObject current=null] : iv_ruleAttributeRule= ruleAttributeRule EOF ;
    public final EObject entryRuleAttributeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1978:54: (iv_ruleAttributeRule= ruleAttributeRule EOF )
            // InternalDataDescriptionLanguage.g:1979:2: iv_ruleAttributeRule= ruleAttributeRule EOF
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
    // InternalDataDescriptionLanguage.g:1985:1: ruleAttributeRule returns [EObject current=null] : ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' ) ;
    public final EObject ruleAttributeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1991:2: ( ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' ) )
            // InternalDataDescriptionLanguage.g:1992:2: ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' )
            {
            // InternalDataDescriptionLanguage.g:1992:2: ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';' )
            // InternalDataDescriptionLanguage.g:1993:3: ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleValueRule ) ) otherlv_3= ';'
            {
            // InternalDataDescriptionLanguage.g:1993:3: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:1994:4: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:1994:4: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:1995:5: ruleStringOrId
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
            pushFollow(FOLLOW_37);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,39,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1());
              		
            }
            // InternalDataDescriptionLanguage.g:2016:3: ( (lv_value_2_0= ruleValueRule ) )
            // InternalDataDescriptionLanguage.g:2017:4: (lv_value_2_0= ruleValueRule )
            {
            // InternalDataDescriptionLanguage.g:2017:4: (lv_value_2_0= ruleValueRule )
            // InternalDataDescriptionLanguage.g:2018:5: lv_value_2_0= ruleValueRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeRuleAccess().getValueValueRuleParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_11);
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

            otherlv_3=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2043:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2043:58: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:2044:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:2050:1: ruleNumberLiteralRule returns [EObject current=null] : (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_DoubleLiteralRule_0 = null;

        EObject this_IntegerLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2056:2: ( (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) )
            // InternalDataDescriptionLanguage.g:2057:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            {
            // InternalDataDescriptionLanguage.g:2057:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_DOUBLE) ) {
                alt35=1;
            }
            else if ( (LA35_0==RULE_INT) ) {
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
                    // InternalDataDescriptionLanguage.g:2058:3: this_DoubleLiteralRule_0= ruleDoubleLiteralRule
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
                    // InternalDataDescriptionLanguage.g:2070:3: this_IntegerLiteralRule_1= ruleIntegerLiteralRule
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
    // InternalDataDescriptionLanguage.g:2085:1: entryRuleDoubleLiteralRule returns [EObject current=null] : iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF ;
    public final EObject entryRuleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2085:58: (iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:2086:2: iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:2092:1: ruleDoubleLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2098:2: ( ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalDataDescriptionLanguage.g:2099:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalDataDescriptionLanguage.g:2099:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalDataDescriptionLanguage.g:2100:3: ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalDataDescriptionLanguage.g:2100:3: ( (lv_literal_0_0= RULE_DOUBLE ) )
            // InternalDataDescriptionLanguage.g:2101:4: (lv_literal_0_0= RULE_DOUBLE )
            {
            // InternalDataDescriptionLanguage.g:2101:4: (lv_literal_0_0= RULE_DOUBLE )
            // InternalDataDescriptionLanguage.g:2102:5: lv_literal_0_0= RULE_DOUBLE
            {
            lv_literal_0_0=(Token)match(input,RULE_DOUBLE,FOLLOW_38); if (state.failed) return current;
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

            // InternalDataDescriptionLanguage.g:2118:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=70 && LA36_0<=89)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2119:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalDataDescriptionLanguage.g:2119:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalDataDescriptionLanguage.g:2120:5: lv_factor_1_0= ruleFactorRule
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
    // InternalDataDescriptionLanguage.g:2141:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2141:59: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:2142:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:2148:1: ruleIntegerLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2154:2: ( ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalDataDescriptionLanguage.g:2155:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalDataDescriptionLanguage.g:2155:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalDataDescriptionLanguage.g:2156:3: ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalDataDescriptionLanguage.g:2156:3: ( (lv_literal_0_0= RULE_INT ) )
            // InternalDataDescriptionLanguage.g:2157:4: (lv_literal_0_0= RULE_INT )
            {
            // InternalDataDescriptionLanguage.g:2157:4: (lv_literal_0_0= RULE_INT )
            // InternalDataDescriptionLanguage.g:2158:5: lv_literal_0_0= RULE_INT
            {
            lv_literal_0_0=(Token)match(input,RULE_INT,FOLLOW_38); if (state.failed) return current;
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

            // InternalDataDescriptionLanguage.g:2174:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=70 && LA37_0<=89)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2175:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalDataDescriptionLanguage.g:2175:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalDataDescriptionLanguage.g:2176:5: lv_factor_1_0= ruleFactorRule
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
    // InternalDataDescriptionLanguage.g:2197:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2197:58: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:2198:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:2204:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2210:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalDataDescriptionLanguage.g:2211:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalDataDescriptionLanguage.g:2211:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:2212:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:2212:3: (lv_value_0_0= RULE_STRING )
            // InternalDataDescriptionLanguage.g:2213:4: lv_value_0_0= RULE_STRING
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
    // InternalDataDescriptionLanguage.g:2232:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2232:59: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:2233:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:2239:1: ruleBooleanLiteralRule returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2245:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalDataDescriptionLanguage.g:2246:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalDataDescriptionLanguage.g:2246:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalDataDescriptionLanguage.g:2247:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalDataDescriptionLanguage.g:2247:3: ()
            // InternalDataDescriptionLanguage.g:2248:4: 
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

            // InternalDataDescriptionLanguage.g:2257:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==40) ) {
                alt38=1;
            }
            else if ( (LA38_0==41) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2258:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalDataDescriptionLanguage.g:2258:4: ( (lv_value_1_0= 'true' ) )
                    // InternalDataDescriptionLanguage.g:2259:5: (lv_value_1_0= 'true' )
                    {
                    // InternalDataDescriptionLanguage.g:2259:5: (lv_value_1_0= 'true' )
                    // InternalDataDescriptionLanguage.g:2260:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
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
                    // InternalDataDescriptionLanguage.g:2273:4: otherlv_2= 'false'
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


    // $ANTLR start "entryRuleAttributeDefinitionRule"
    // InternalDataDescriptionLanguage.g:2282:1: entryRuleAttributeDefinitionRule returns [EObject current=null] : iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF ;
    public final EObject entryRuleAttributeDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeDefinitionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2282:64: (iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF )
            // InternalDataDescriptionLanguage.g:2283:2: iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF
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
    // InternalDataDescriptionLanguage.g:2289:1: ruleAttributeDefinitionRule returns [EObject current=null] : ( ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';' ) ;
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
            // InternalDataDescriptionLanguage.g:2295:2: ( ( ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';' ) )
            // InternalDataDescriptionLanguage.g:2296:2: ( ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';' )
            {
            // InternalDataDescriptionLanguage.g:2296:2: ( ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';' )
            // InternalDataDescriptionLanguage.g:2297:3: ( (lv_name_0_0= ruleStringOrId ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeRule ) ) (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )? otherlv_5= ';'
            {
            // InternalDataDescriptionLanguage.g:2297:3: ( (lv_name_0_0= ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:2298:4: (lv_name_0_0= ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:2298:4: (lv_name_0_0= ruleStringOrId )
            // InternalDataDescriptionLanguage.g:2299:5: lv_name_0_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_7);
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

            otherlv_1=(Token)match(input,18,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_1());
              		
            }
            // InternalDataDescriptionLanguage.g:2320:3: ( (lv_type_2_0= ruleTypeRule ) )
            // InternalDataDescriptionLanguage.g:2321:4: (lv_type_2_0= ruleTypeRule )
            {
            // InternalDataDescriptionLanguage.g:2321:4: (lv_type_2_0= ruleTypeRule )
            // InternalDataDescriptionLanguage.g:2322:5: lv_type_2_0= ruleTypeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_40);
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

            // InternalDataDescriptionLanguage.g:2339:3: (otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==39) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2340:4: otherlv_3= ':=' ( (lv_initialisation_4_0= ruleExpressionRule ) )
                    {
                    otherlv_3=(Token)match(input,39,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_3_0());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:2344:4: ( (lv_initialisation_4_0= ruleExpressionRule ) )
                    // InternalDataDescriptionLanguage.g:2345:5: (lv_initialisation_4_0= ruleExpressionRule )
                    {
                    // InternalDataDescriptionLanguage.g:2345:5: (lv_initialisation_4_0= ruleExpressionRule )
                    // InternalDataDescriptionLanguage.g:2346:6: lv_initialisation_4_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationExpressionRuleParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_11);
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

            otherlv_5=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2372:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
    public final EObject entryRuleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2372:49: (iv_ruleTypeRule= ruleTypeRule EOF )
            // InternalDataDescriptionLanguage.g:2373:2: iv_ruleTypeRule= ruleTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:2379:1: ruleTypeRule returns [EObject current=null] : (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_FloatTypeRule_2= ruleFloatTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule ) ;
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
            // InternalDataDescriptionLanguage.g:2385:2: ( (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_FloatTypeRule_2= ruleFloatTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule ) )
            // InternalDataDescriptionLanguage.g:2386:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_FloatTypeRule_2= ruleFloatTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule )
            {
            // InternalDataDescriptionLanguage.g:2386:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_FloatTypeRule_2= ruleFloatTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule )
            int alt40=10;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt40=1;
                }
                break;
            case 47:
                {
                alt40=2;
                }
                break;
            case 48:
                {
                alt40=3;
                }
                break;
            case 49:
                {
                alt40=4;
                }
                break;
            case 42:
                {
                alt40=5;
                }
                break;
            case 51:
                {
                alt40=6;
                }
                break;
            case 43:
                {
                alt40=7;
                }
                break;
            case 50:
                {
                alt40=8;
                }
                break;
            case 46:
                {
                alt40=9;
                }
                break;
            case 19:
                {
                alt40=10;
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
                    // InternalDataDescriptionLanguage.g:2387:3: this_StringTypeRule_0= ruleStringTypeRule
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
                    // InternalDataDescriptionLanguage.g:2399:3: this_IntTypeRule_1= ruleIntTypeRule
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
                    // InternalDataDescriptionLanguage.g:2411:3: this_FloatTypeRule_2= ruleFloatTypeRule
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
                    // InternalDataDescriptionLanguage.g:2423:3: this_BooleanTypeRule_3= ruleBooleanTypeRule
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
                    // InternalDataDescriptionLanguage.g:2435:3: this_LiteralTypeRule_4= ruleLiteralTypeRule
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
                    // InternalDataDescriptionLanguage.g:2447:3: this_ArrayTypeRule_5= ruleArrayTypeRule
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
                    // InternalDataDescriptionLanguage.g:2459:3: this_InstanceTypeRule_6= ruleInstanceTypeRule
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
                    // InternalDataDescriptionLanguage.g:2471:3: this_VoidTypeRule_7= ruleVoidTypeRule
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
                    // InternalDataDescriptionLanguage.g:2483:3: this_ExpressionTypeRule_8= ruleExpressionTypeRule
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
                    // InternalDataDescriptionLanguage.g:2495:3: this_DataTypeRule_9= ruleDataTypeRule
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
    // InternalDataDescriptionLanguage.g:2510:1: entryRuleLiteralTypeRule returns [EObject current=null] : iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF ;
    public final EObject entryRuleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2510:56: (iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF )
            // InternalDataDescriptionLanguage.g:2511:2: iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:2517:1: ruleLiteralTypeRule returns [EObject current=null] : ( () otherlv_1= 'literal' ) ;
    public final EObject ruleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2523:2: ( ( () otherlv_1= 'literal' ) )
            // InternalDataDescriptionLanguage.g:2524:2: ( () otherlv_1= 'literal' )
            {
            // InternalDataDescriptionLanguage.g:2524:2: ( () otherlv_1= 'literal' )
            // InternalDataDescriptionLanguage.g:2525:3: () otherlv_1= 'literal'
            {
            // InternalDataDescriptionLanguage.g:2525:3: ()
            // InternalDataDescriptionLanguage.g:2526:4: 
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

            otherlv_1=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2543:1: entryRuleInstanceTypeRule returns [EObject current=null] : iv_ruleInstanceTypeRule= ruleInstanceTypeRule EOF ;
    public final EObject entryRuleInstanceTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2543:57: (iv_ruleInstanceTypeRule= ruleInstanceTypeRule EOF )
            // InternalDataDescriptionLanguage.g:2544:2: iv_ruleInstanceTypeRule= ruleInstanceTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:2550:1: ruleInstanceTypeRule returns [EObject current=null] : ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) (otherlv_3= '|' ( ( ruleQualifiedName ) ) )* ) ;
    public final EObject ruleInstanceTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2556:2: ( ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) (otherlv_3= '|' ( ( ruleQualifiedName ) ) )* ) )
            // InternalDataDescriptionLanguage.g:2557:2: ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) (otherlv_3= '|' ( ( ruleQualifiedName ) ) )* )
            {
            // InternalDataDescriptionLanguage.g:2557:2: ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) (otherlv_3= '|' ( ( ruleQualifiedName ) ) )* )
            // InternalDataDescriptionLanguage.g:2558:3: () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) (otherlv_3= '|' ( ( ruleQualifiedName ) ) )*
            {
            // InternalDataDescriptionLanguage.g:2558:3: ()
            // InternalDataDescriptionLanguage.g:2559:4: 
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

            otherlv_1=(Token)match(input,43,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInstanceTypeRuleAccess().getInstanceKeyword_1());
              		
            }
            // InternalDataDescriptionLanguage.g:2572:3: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:2573:4: ( ruleQualifiedName )
            {
            // InternalDataDescriptionLanguage.g:2573:4: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:2574:5: ruleQualifiedName
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

              					newCompositeNode(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_41);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalDataDescriptionLanguage.g:2591:3: (otherlv_3= '|' ( ( ruleQualifiedName ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==44) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2592:4: otherlv_3= '|' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_3=(Token)match(input,44,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getInstanceTypeRuleAccess().getVerticalLineKeyword_3_0());
            	      			
            	    }
            	    // InternalDataDescriptionLanguage.g:2596:4: ( ( ruleQualifiedName ) )
            	    // InternalDataDescriptionLanguage.g:2597:5: ( ruleQualifiedName )
            	    {
            	    // InternalDataDescriptionLanguage.g:2597:5: ( ruleQualifiedName )
            	    // InternalDataDescriptionLanguage.g:2598:6: ruleQualifiedName
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

            	      						newCompositeNode(grammarAccess.getInstanceTypeRuleAccess().getDefinitionsTypeDefinitionCrossReference_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_41);
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
            	    break loop41;
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
    // $ANTLR end "ruleInstanceTypeRule"


    // $ANTLR start "entryRuleStringTypeRule"
    // InternalDataDescriptionLanguage.g:2620:1: entryRuleStringTypeRule returns [EObject current=null] : iv_ruleStringTypeRule= ruleStringTypeRule EOF ;
    public final EObject entryRuleStringTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2620:55: (iv_ruleStringTypeRule= ruleStringTypeRule EOF )
            // InternalDataDescriptionLanguage.g:2621:2: iv_ruleStringTypeRule= ruleStringTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:2627:1: ruleStringTypeRule returns [EObject current=null] : ( () otherlv_1= 'string' ) ;
    public final EObject ruleStringTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2633:2: ( ( () otherlv_1= 'string' ) )
            // InternalDataDescriptionLanguage.g:2634:2: ( () otherlv_1= 'string' )
            {
            // InternalDataDescriptionLanguage.g:2634:2: ( () otherlv_1= 'string' )
            // InternalDataDescriptionLanguage.g:2635:3: () otherlv_1= 'string'
            {
            // InternalDataDescriptionLanguage.g:2635:3: ()
            // InternalDataDescriptionLanguage.g:2636:4: 
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

            otherlv_1=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2653:1: entryRuleExpressionTypeRule returns [EObject current=null] : iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF ;
    public final EObject entryRuleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2653:59: (iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF )
            // InternalDataDescriptionLanguage.g:2654:2: iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:2660:1: ruleExpressionTypeRule returns [EObject current=null] : ( () otherlv_1= 'expression' ) ;
    public final EObject ruleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2666:2: ( ( () otherlv_1= 'expression' ) )
            // InternalDataDescriptionLanguage.g:2667:2: ( () otherlv_1= 'expression' )
            {
            // InternalDataDescriptionLanguage.g:2667:2: ( () otherlv_1= 'expression' )
            // InternalDataDescriptionLanguage.g:2668:3: () otherlv_1= 'expression'
            {
            // InternalDataDescriptionLanguage.g:2668:3: ()
            // InternalDataDescriptionLanguage.g:2669:4: 
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

            otherlv_1=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2686:1: entryRuleIntTypeRule returns [EObject current=null] : iv_ruleIntTypeRule= ruleIntTypeRule EOF ;
    public final EObject entryRuleIntTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2686:52: (iv_ruleIntTypeRule= ruleIntTypeRule EOF )
            // InternalDataDescriptionLanguage.g:2687:2: iv_ruleIntTypeRule= ruleIntTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:2693:1: ruleIntTypeRule returns [EObject current=null] : ( () otherlv_1= 'int' ) ;
    public final EObject ruleIntTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2699:2: ( ( () otherlv_1= 'int' ) )
            // InternalDataDescriptionLanguage.g:2700:2: ( () otherlv_1= 'int' )
            {
            // InternalDataDescriptionLanguage.g:2700:2: ( () otherlv_1= 'int' )
            // InternalDataDescriptionLanguage.g:2701:3: () otherlv_1= 'int'
            {
            // InternalDataDescriptionLanguage.g:2701:3: ()
            // InternalDataDescriptionLanguage.g:2702:4: 
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

            otherlv_1=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2719:1: entryRuleFloatTypeRule returns [EObject current=null] : iv_ruleFloatTypeRule= ruleFloatTypeRule EOF ;
    public final EObject entryRuleFloatTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2719:54: (iv_ruleFloatTypeRule= ruleFloatTypeRule EOF )
            // InternalDataDescriptionLanguage.g:2720:2: iv_ruleFloatTypeRule= ruleFloatTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:2726:1: ruleFloatTypeRule returns [EObject current=null] : ( () otherlv_1= 'float' ) ;
    public final EObject ruleFloatTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2732:2: ( ( () otherlv_1= 'float' ) )
            // InternalDataDescriptionLanguage.g:2733:2: ( () otherlv_1= 'float' )
            {
            // InternalDataDescriptionLanguage.g:2733:2: ( () otherlv_1= 'float' )
            // InternalDataDescriptionLanguage.g:2734:3: () otherlv_1= 'float'
            {
            // InternalDataDescriptionLanguage.g:2734:3: ()
            // InternalDataDescriptionLanguage.g:2735:4: 
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

            otherlv_1=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2752:1: entryRuleBooleanTypeRule returns [EObject current=null] : iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF ;
    public final EObject entryRuleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2752:56: (iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF )
            // InternalDataDescriptionLanguage.g:2753:2: iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:2759:1: ruleBooleanTypeRule returns [EObject current=null] : ( () otherlv_1= 'boolean' ) ;
    public final EObject ruleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2765:2: ( ( () otherlv_1= 'boolean' ) )
            // InternalDataDescriptionLanguage.g:2766:2: ( () otherlv_1= 'boolean' )
            {
            // InternalDataDescriptionLanguage.g:2766:2: ( () otherlv_1= 'boolean' )
            // InternalDataDescriptionLanguage.g:2767:3: () otherlv_1= 'boolean'
            {
            // InternalDataDescriptionLanguage.g:2767:3: ()
            // InternalDataDescriptionLanguage.g:2768:4: 
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

            otherlv_1=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2785:1: entryRuleVoidTypeRule returns [EObject current=null] : iv_ruleVoidTypeRule= ruleVoidTypeRule EOF ;
    public final EObject entryRuleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVoidTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2785:53: (iv_ruleVoidTypeRule= ruleVoidTypeRule EOF )
            // InternalDataDescriptionLanguage.g:2786:2: iv_ruleVoidTypeRule= ruleVoidTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:2792:1: ruleVoidTypeRule returns [EObject current=null] : ( () otherlv_1= 'void' ) ;
    public final EObject ruleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2798:2: ( ( () otherlv_1= 'void' ) )
            // InternalDataDescriptionLanguage.g:2799:2: ( () otherlv_1= 'void' )
            {
            // InternalDataDescriptionLanguage.g:2799:2: ( () otherlv_1= 'void' )
            // InternalDataDescriptionLanguage.g:2800:3: () otherlv_1= 'void'
            {
            // InternalDataDescriptionLanguage.g:2800:3: ()
            // InternalDataDescriptionLanguage.g:2801:4: 
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

            otherlv_1=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2818:1: entryRuleDataTypeRule returns [EObject current=null] : iv_ruleDataTypeRule= ruleDataTypeRule EOF ;
    public final EObject entryRuleDataTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2818:53: (iv_ruleDataTypeRule= ruleDataTypeRule EOF )
            // InternalDataDescriptionLanguage.g:2819:2: iv_ruleDataTypeRule= ruleDataTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:2825:1: ruleDataTypeRule returns [EObject current=null] : ( () otherlv_1= 'data' ) ;
    public final EObject ruleDataTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2831:2: ( ( () otherlv_1= 'data' ) )
            // InternalDataDescriptionLanguage.g:2832:2: ( () otherlv_1= 'data' )
            {
            // InternalDataDescriptionLanguage.g:2832:2: ( () otherlv_1= 'data' )
            // InternalDataDescriptionLanguage.g:2833:3: () otherlv_1= 'data'
            {
            // InternalDataDescriptionLanguage.g:2833:3: ()
            // InternalDataDescriptionLanguage.g:2834:4: 
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

            otherlv_1=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2851:1: entryRuleArrayTypeRule returns [EObject current=null] : iv_ruleArrayTypeRule= ruleArrayTypeRule EOF ;
    public final EObject entryRuleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2851:54: (iv_ruleArrayTypeRule= ruleArrayTypeRule EOF )
            // InternalDataDescriptionLanguage.g:2852:2: iv_ruleArrayTypeRule= ruleArrayTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:2858:1: ruleArrayTypeRule returns [EObject current=null] : (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) ;
    public final EObject ruleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_elements_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2864:2: ( (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) )
            // InternalDataDescriptionLanguage.g:2865:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            {
            // InternalDataDescriptionLanguage.g:2865:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            // InternalDataDescriptionLanguage.g:2866:3: otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) )
            {
            otherlv_0=(Token)match(input,51,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0());
              		
            }
            // InternalDataDescriptionLanguage.g:2870:3: ( (lv_elements_1_0= ruleTypeRule ) )
            // InternalDataDescriptionLanguage.g:2871:4: (lv_elements_1_0= ruleTypeRule )
            {
            // InternalDataDescriptionLanguage.g:2871:4: (lv_elements_1_0= ruleTypeRule )
            // InternalDataDescriptionLanguage.g:2872:5: lv_elements_1_0= ruleTypeRule
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
    // InternalDataDescriptionLanguage.g:2893:1: entryRuleParameterRule returns [EObject current=null] : iv_ruleParameterRule= ruleParameterRule EOF ;
    public final EObject entryRuleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2893:54: (iv_ruleParameterRule= ruleParameterRule EOF )
            // InternalDataDescriptionLanguage.g:2894:2: iv_ruleParameterRule= ruleParameterRule EOF
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
    // InternalDataDescriptionLanguage.g:2900:1: ruleParameterRule returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) ;
    public final EObject ruleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2906:2: ( ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) )
            // InternalDataDescriptionLanguage.g:2907:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            {
            // InternalDataDescriptionLanguage.g:2907:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            // InternalDataDescriptionLanguage.g:2908:3: ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) )
            {
            // InternalDataDescriptionLanguage.g:2908:3: ( (lv_type_0_0= ruleTypeRule ) )
            // InternalDataDescriptionLanguage.g:2909:4: (lv_type_0_0= ruleTypeRule )
            {
            // InternalDataDescriptionLanguage.g:2909:4: (lv_type_0_0= ruleTypeRule )
            // InternalDataDescriptionLanguage.g:2910:5: lv_type_0_0= ruleTypeRule
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

            // InternalDataDescriptionLanguage.g:2927:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:2928:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:2928:4: (lv_name_1_0= ruleStringOrId )
            // InternalDataDescriptionLanguage.g:2929:5: lv_name_1_0= ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:2950:1: entryRuleFunctionNameRule returns [EObject current=null] : iv_ruleFunctionNameRule= ruleFunctionNameRule EOF ;
    public final EObject entryRuleFunctionNameRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionNameRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2950:57: (iv_ruleFunctionNameRule= ruleFunctionNameRule EOF )
            // InternalDataDescriptionLanguage.g:2951:2: iv_ruleFunctionNameRule= ruleFunctionNameRule EOF
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
    // InternalDataDescriptionLanguage.g:2957:1: ruleFunctionNameRule returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleFunctionNameRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2963:2: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDescriptionLanguage.g:2964:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDescriptionLanguage.g:2964:2: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:2965:3: ( ruleQualifiedName )
            {
            // InternalDataDescriptionLanguage.g:2965:3: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:2966:4: ruleQualifiedName
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
    // InternalDataDescriptionLanguage.g:2986:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalDataDescriptionLanguage.g:2986:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalDataDescriptionLanguage.g:2987:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalDataDescriptionLanguage.g:2993:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_StringOrId_0 = null;

        AntlrDatatypeRuleToken this_StringOrId_2 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2999:2: ( (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) )
            // InternalDataDescriptionLanguage.g:3000:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            {
            // InternalDataDescriptionLanguage.g:3000:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            // InternalDataDescriptionLanguage.g:3001:3: this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_42);
            this_StringOrId_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_StringOrId_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalDataDescriptionLanguage.g:3011:3: (kw= '.' this_StringOrId_2= ruleStringOrId )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==52) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3012:4: kw= '.' this_StringOrId_2= ruleStringOrId
            	    {
            	    kw=(Token)match(input,52,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_42);
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
    // InternalDataDescriptionLanguage.g:3032:1: entryRuleStringOrId returns [String current=null] : iv_ruleStringOrId= ruleStringOrId EOF ;
    public final String entryRuleStringOrId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringOrId = null;


        try {
            // InternalDataDescriptionLanguage.g:3032:50: (iv_ruleStringOrId= ruleStringOrId EOF )
            // InternalDataDescriptionLanguage.g:3033:2: iv_ruleStringOrId= ruleStringOrId EOF
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
    // InternalDataDescriptionLanguage.g:3039:1: ruleStringOrId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleStringOrId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_QUOTED_ID_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3045:2: ( (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) )
            // InternalDataDescriptionLanguage.g:3046:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            {
            // InternalDataDescriptionLanguage.g:3046:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
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
                    // InternalDataDescriptionLanguage.g:3047:3: this_QUOTED_ID_0= RULE_QUOTED_ID
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
                    // InternalDataDescriptionLanguage.g:3055:3: this_ID_1= RULE_ID
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
    // InternalDataDescriptionLanguage.g:3066:1: ruleScaleType returns [Enumerator current=null] : ( (enumLiteral_0= 'nominal' ) | (enumLiteral_1= 'ordinal' ) | (enumLiteral_2= 'cardinal' ) | (enumLiteral_3= 'quotient' ) ) ;
    public final Enumerator ruleScaleType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3072:2: ( ( (enumLiteral_0= 'nominal' ) | (enumLiteral_1= 'ordinal' ) | (enumLiteral_2= 'cardinal' ) | (enumLiteral_3= 'quotient' ) ) )
            // InternalDataDescriptionLanguage.g:3073:2: ( (enumLiteral_0= 'nominal' ) | (enumLiteral_1= 'ordinal' ) | (enumLiteral_2= 'cardinal' ) | (enumLiteral_3= 'quotient' ) )
            {
            // InternalDataDescriptionLanguage.g:3073:2: ( (enumLiteral_0= 'nominal' ) | (enumLiteral_1= 'ordinal' ) | (enumLiteral_2= 'cardinal' ) | (enumLiteral_3= 'quotient' ) )
            int alt44=4;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt44=1;
                }
                break;
            case 54:
                {
                alt44=2;
                }
                break;
            case 55:
                {
                alt44=3;
                }
                break;
            case 56:
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
                    // InternalDataDescriptionLanguage.g:3074:3: (enumLiteral_0= 'nominal' )
                    {
                    // InternalDataDescriptionLanguage.g:3074:3: (enumLiteral_0= 'nominal' )
                    // InternalDataDescriptionLanguage.g:3075:4: enumLiteral_0= 'nominal'
                    {
                    enumLiteral_0=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getScaleTypeAccess().getNominalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getScaleTypeAccess().getNominalEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:3082:3: (enumLiteral_1= 'ordinal' )
                    {
                    // InternalDataDescriptionLanguage.g:3082:3: (enumLiteral_1= 'ordinal' )
                    // InternalDataDescriptionLanguage.g:3083:4: enumLiteral_1= 'ordinal'
                    {
                    enumLiteral_1=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getScaleTypeAccess().getOrdinalEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getScaleTypeAccess().getOrdinalEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:3090:3: (enumLiteral_2= 'cardinal' )
                    {
                    // InternalDataDescriptionLanguage.g:3090:3: (enumLiteral_2= 'cardinal' )
                    // InternalDataDescriptionLanguage.g:3091:4: enumLiteral_2= 'cardinal'
                    {
                    enumLiteral_2=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getScaleTypeAccess().getCardinalEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getScaleTypeAccess().getCardinalEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:3098:3: (enumLiteral_3= 'quotient' )
                    {
                    // InternalDataDescriptionLanguage.g:3098:3: (enumLiteral_3= 'quotient' )
                    // InternalDataDescriptionLanguage.g:3099:4: enumLiteral_3= 'quotient'
                    {
                    enumLiteral_3=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "ruleRepresentationType"
    // InternalDataDescriptionLanguage.g:3109:1: ruleRepresentationType returns [Enumerator current=null] : ( (enumLiteral_0= 'real' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'string' ) ) ;
    public final Enumerator ruleRepresentationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3115:2: ( ( (enumLiteral_0= 'real' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'string' ) ) )
            // InternalDataDescriptionLanguage.g:3116:2: ( (enumLiteral_0= 'real' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'string' ) )
            {
            // InternalDataDescriptionLanguage.g:3116:2: ( (enumLiteral_0= 'real' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'string' ) )
            int alt45=4;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt45=1;
                }
                break;
            case 58:
                {
                alt45=2;
                }
                break;
            case 49:
                {
                alt45=3;
                }
                break;
            case 45:
                {
                alt45=4;
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
                    // InternalDataDescriptionLanguage.g:3117:3: (enumLiteral_0= 'real' )
                    {
                    // InternalDataDescriptionLanguage.g:3117:3: (enumLiteral_0= 'real' )
                    // InternalDataDescriptionLanguage.g:3118:4: enumLiteral_0= 'real'
                    {
                    enumLiteral_0=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRepresentationTypeAccess().getRealEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRepresentationTypeAccess().getRealEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:3125:3: (enumLiteral_1= 'integer' )
                    {
                    // InternalDataDescriptionLanguage.g:3125:3: (enumLiteral_1= 'integer' )
                    // InternalDataDescriptionLanguage.g:3126:4: enumLiteral_1= 'integer'
                    {
                    enumLiteral_1=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRepresentationTypeAccess().getIntegerEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRepresentationTypeAccess().getIntegerEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:3133:3: (enumLiteral_2= 'boolean' )
                    {
                    // InternalDataDescriptionLanguage.g:3133:3: (enumLiteral_2= 'boolean' )
                    // InternalDataDescriptionLanguage.g:3134:4: enumLiteral_2= 'boolean'
                    {
                    enumLiteral_2=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRepresentationTypeAccess().getBooleanEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getRepresentationTypeAccess().getBooleanEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:3141:3: (enumLiteral_3= 'string' )
                    {
                    // InternalDataDescriptionLanguage.g:3141:3: (enumLiteral_3= 'string' )
                    // InternalDataDescriptionLanguage.g:3142:4: enumLiteral_3= 'string'
                    {
                    enumLiteral_3=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRepresentationTypeAccess().getStringEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getRepresentationTypeAccess().getStringEnumLiteralDeclaration_3());
                      			
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
    // $ANTLR end "ruleRepresentationType"


    // $ANTLR start "ruleComparisonOperatorRule"
    // InternalDataDescriptionLanguage.g:3152:1: ruleComparisonOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) ;
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
            // InternalDataDescriptionLanguage.g:3158:2: ( ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) )
            // InternalDataDescriptionLanguage.g:3159:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalDataDescriptionLanguage.g:3159:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            int alt46=6;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt46=1;
                }
                break;
            case 60:
                {
                alt46=2;
                }
                break;
            case 61:
                {
                alt46=3;
                }
                break;
            case 62:
                {
                alt46=4;
                }
                break;
            case 63:
                {
                alt46=5;
                }
                break;
            case 64:
                {
                alt46=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3160:3: (enumLiteral_0= '>=' )
                    {
                    // InternalDataDescriptionLanguage.g:3160:3: (enumLiteral_0= '>=' )
                    // InternalDataDescriptionLanguage.g:3161:4: enumLiteral_0= '>='
                    {
                    enumLiteral_0=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:3168:3: (enumLiteral_1= '>' )
                    {
                    // InternalDataDescriptionLanguage.g:3168:3: (enumLiteral_1= '>' )
                    // InternalDataDescriptionLanguage.g:3169:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:3176:3: (enumLiteral_2= '=' )
                    {
                    // InternalDataDescriptionLanguage.g:3176:3: (enumLiteral_2= '=' )
                    // InternalDataDescriptionLanguage.g:3177:4: enumLiteral_2= '='
                    {
                    enumLiteral_2=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:3184:3: (enumLiteral_3= '!=' )
                    {
                    // InternalDataDescriptionLanguage.g:3184:3: (enumLiteral_3= '!=' )
                    // InternalDataDescriptionLanguage.g:3185:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalDataDescriptionLanguage.g:3192:3: (enumLiteral_4= '<' )
                    {
                    // InternalDataDescriptionLanguage.g:3192:3: (enumLiteral_4= '<' )
                    // InternalDataDescriptionLanguage.g:3193:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalDataDescriptionLanguage.g:3200:3: (enumLiteral_5= '<=' )
                    {
                    // InternalDataDescriptionLanguage.g:3200:3: (enumLiteral_5= '<=' )
                    // InternalDataDescriptionLanguage.g:3201:4: enumLiteral_5= '<='
                    {
                    enumLiteral_5=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:3211:1: ruleAddOrSubtractOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOrSubtractOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3217:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalDataDescriptionLanguage.g:3218:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalDataDescriptionLanguage.g:3218:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==65) ) {
                alt47=1;
            }
            else if ( (LA47_0==66) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3219:3: (enumLiteral_0= '+' )
                    {
                    // InternalDataDescriptionLanguage.g:3219:3: (enumLiteral_0= '+' )
                    // InternalDataDescriptionLanguage.g:3220:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:3227:3: (enumLiteral_1= '-' )
                    {
                    // InternalDataDescriptionLanguage.g:3227:3: (enumLiteral_1= '-' )
                    // InternalDataDescriptionLanguage.g:3228:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:3238:1: ruleMultiplyDivideModuloOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3244:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalDataDescriptionLanguage.g:3245:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalDataDescriptionLanguage.g:3245:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt48=3;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt48=1;
                }
                break;
            case 68:
                {
                alt48=2;
                }
                break;
            case 69:
                {
                alt48=3;
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
                    // InternalDataDescriptionLanguage.g:3246:3: (enumLiteral_0= '*' )
                    {
                    // InternalDataDescriptionLanguage.g:3246:3: (enumLiteral_0= '*' )
                    // InternalDataDescriptionLanguage.g:3247:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:3254:3: (enumLiteral_1= '/' )
                    {
                    // InternalDataDescriptionLanguage.g:3254:3: (enumLiteral_1= '/' )
                    // InternalDataDescriptionLanguage.g:3255:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:3262:3: (enumLiteral_2= '%' )
                    {
                    // InternalDataDescriptionLanguage.g:3262:3: (enumLiteral_2= '%' )
                    // InternalDataDescriptionLanguage.g:3263:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:3273:1: ruleFactorRule returns [Enumerator current=null] : ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) ;
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
            // InternalDataDescriptionLanguage.g:3279:2: ( ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) )
            // InternalDataDescriptionLanguage.g:3280:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            {
            // InternalDataDescriptionLanguage.g:3280:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            int alt49=20;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt49=1;
                }
                break;
            case 71:
                {
                alt49=2;
                }
                break;
            case 72:
                {
                alt49=3;
                }
                break;
            case 73:
                {
                alt49=4;
                }
                break;
            case 74:
                {
                alt49=5;
                }
                break;
            case 75:
                {
                alt49=6;
                }
                break;
            case 76:
                {
                alt49=7;
                }
                break;
            case 77:
                {
                alt49=8;
                }
                break;
            case 78:
                {
                alt49=9;
                }
                break;
            case 79:
                {
                alt49=10;
                }
                break;
            case 80:
                {
                alt49=11;
                }
                break;
            case 81:
                {
                alt49=12;
                }
                break;
            case 82:
                {
                alt49=13;
                }
                break;
            case 83:
                {
                alt49=14;
                }
                break;
            case 84:
                {
                alt49=15;
                }
                break;
            case 85:
                {
                alt49=16;
                }
                break;
            case 86:
                {
                alt49=17;
                }
                break;
            case 87:
                {
                alt49=18;
                }
                break;
            case 88:
                {
                alt49=19;
                }
                break;
            case 89:
                {
                alt49=20;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3281:3: (enumLiteral_0= 'Y' )
                    {
                    // InternalDataDescriptionLanguage.g:3281:3: (enumLiteral_0= 'Y' )
                    // InternalDataDescriptionLanguage.g:3282:4: enumLiteral_0= 'Y'
                    {
                    enumLiteral_0=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:3289:3: (enumLiteral_1= 'Z' )
                    {
                    // InternalDataDescriptionLanguage.g:3289:3: (enumLiteral_1= 'Z' )
                    // InternalDataDescriptionLanguage.g:3290:4: enumLiteral_1= 'Z'
                    {
                    enumLiteral_1=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:3297:3: (enumLiteral_2= 'E' )
                    {
                    // InternalDataDescriptionLanguage.g:3297:3: (enumLiteral_2= 'E' )
                    // InternalDataDescriptionLanguage.g:3298:4: enumLiteral_2= 'E'
                    {
                    enumLiteral_2=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:3305:3: (enumLiteral_3= 'P' )
                    {
                    // InternalDataDescriptionLanguage.g:3305:3: (enumLiteral_3= 'P' )
                    // InternalDataDescriptionLanguage.g:3306:4: enumLiteral_3= 'P'
                    {
                    enumLiteral_3=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalDataDescriptionLanguage.g:3313:3: (enumLiteral_4= 'T' )
                    {
                    // InternalDataDescriptionLanguage.g:3313:3: (enumLiteral_4= 'T' )
                    // InternalDataDescriptionLanguage.g:3314:4: enumLiteral_4= 'T'
                    {
                    enumLiteral_4=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalDataDescriptionLanguage.g:3321:3: (enumLiteral_5= 'G' )
                    {
                    // InternalDataDescriptionLanguage.g:3321:3: (enumLiteral_5= 'G' )
                    // InternalDataDescriptionLanguage.g:3322:4: enumLiteral_5= 'G'
                    {
                    enumLiteral_5=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalDataDescriptionLanguage.g:3329:3: (enumLiteral_6= 'M' )
                    {
                    // InternalDataDescriptionLanguage.g:3329:3: (enumLiteral_6= 'M' )
                    // InternalDataDescriptionLanguage.g:3330:4: enumLiteral_6= 'M'
                    {
                    enumLiteral_6=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalDataDescriptionLanguage.g:3337:3: (enumLiteral_7= 'k' )
                    {
                    // InternalDataDescriptionLanguage.g:3337:3: (enumLiteral_7= 'k' )
                    // InternalDataDescriptionLanguage.g:3338:4: enumLiteral_7= 'k'
                    {
                    enumLiteral_7=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalDataDescriptionLanguage.g:3345:3: (enumLiteral_8= 'h' )
                    {
                    // InternalDataDescriptionLanguage.g:3345:3: (enumLiteral_8= 'h' )
                    // InternalDataDescriptionLanguage.g:3346:4: enumLiteral_8= 'h'
                    {
                    enumLiteral_8=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalDataDescriptionLanguage.g:3353:3: (enumLiteral_9= 'da' )
                    {
                    // InternalDataDescriptionLanguage.g:3353:3: (enumLiteral_9= 'da' )
                    // InternalDataDescriptionLanguage.g:3354:4: enumLiteral_9= 'da'
                    {
                    enumLiteral_9=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalDataDescriptionLanguage.g:3361:3: (enumLiteral_10= 'd' )
                    {
                    // InternalDataDescriptionLanguage.g:3361:3: (enumLiteral_10= 'd' )
                    // InternalDataDescriptionLanguage.g:3362:4: enumLiteral_10= 'd'
                    {
                    enumLiteral_10=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_10, grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10());
                      			
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalDataDescriptionLanguage.g:3369:3: (enumLiteral_11= 'c' )
                    {
                    // InternalDataDescriptionLanguage.g:3369:3: (enumLiteral_11= 'c' )
                    // InternalDataDescriptionLanguage.g:3370:4: enumLiteral_11= 'c'
                    {
                    enumLiteral_11=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_11, grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11());
                      			
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalDataDescriptionLanguage.g:3377:3: (enumLiteral_12= 'm' )
                    {
                    // InternalDataDescriptionLanguage.g:3377:3: (enumLiteral_12= 'm' )
                    // InternalDataDescriptionLanguage.g:3378:4: enumLiteral_12= 'm'
                    {
                    enumLiteral_12=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_12, grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12());
                      			
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalDataDescriptionLanguage.g:3385:3: (enumLiteral_13= '\\u00B5' )
                    {
                    // InternalDataDescriptionLanguage.g:3385:3: (enumLiteral_13= '\\u00B5' )
                    // InternalDataDescriptionLanguage.g:3386:4: enumLiteral_13= '\\u00B5'
                    {
                    enumLiteral_13=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_13, grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13());
                      			
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalDataDescriptionLanguage.g:3393:3: (enumLiteral_14= 'n' )
                    {
                    // InternalDataDescriptionLanguage.g:3393:3: (enumLiteral_14= 'n' )
                    // InternalDataDescriptionLanguage.g:3394:4: enumLiteral_14= 'n'
                    {
                    enumLiteral_14=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_14, grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14());
                      			
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalDataDescriptionLanguage.g:3401:3: (enumLiteral_15= 'p' )
                    {
                    // InternalDataDescriptionLanguage.g:3401:3: (enumLiteral_15= 'p' )
                    // InternalDataDescriptionLanguage.g:3402:4: enumLiteral_15= 'p'
                    {
                    enumLiteral_15=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_15, grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15());
                      			
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalDataDescriptionLanguage.g:3409:3: (enumLiteral_16= 'f' )
                    {
                    // InternalDataDescriptionLanguage.g:3409:3: (enumLiteral_16= 'f' )
                    // InternalDataDescriptionLanguage.g:3410:4: enumLiteral_16= 'f'
                    {
                    enumLiteral_16=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_16, grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16());
                      			
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalDataDescriptionLanguage.g:3417:3: (enumLiteral_17= 'a' )
                    {
                    // InternalDataDescriptionLanguage.g:3417:3: (enumLiteral_17= 'a' )
                    // InternalDataDescriptionLanguage.g:3418:4: enumLiteral_17= 'a'
                    {
                    enumLiteral_17=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_17, grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17());
                      			
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalDataDescriptionLanguage.g:3425:3: (enumLiteral_18= 'z' )
                    {
                    // InternalDataDescriptionLanguage.g:3425:3: (enumLiteral_18= 'z' )
                    // InternalDataDescriptionLanguage.g:3426:4: enumLiteral_18= 'z'
                    {
                    enumLiteral_18=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_18, grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18());
                      			
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalDataDescriptionLanguage.g:3433:3: (enumLiteral_19= 'y' )
                    {
                    // InternalDataDescriptionLanguage.g:3433:3: (enumLiteral_19= 'y' )
                    // InternalDataDescriptionLanguage.g:3434:4: enumLiteral_19= 'y'
                    {
                    enumLiteral_19=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
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

    // $ANTLR start synpred17_InternalDataDescriptionLanguage
    public final void synpred17_InternalDataDescriptionLanguage_fragment() throws RecognitionException {   
        EObject this_ConstantReferenceRule_0 = null;


        // InternalDataDescriptionLanguage.g:743:3: (this_ConstantReferenceRule_0= ruleConstantReferenceRule )
        // InternalDataDescriptionLanguage.g:743:3: this_ConstantReferenceRule_0= ruleConstantReferenceRule
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
    // $ANTLR end synpred17_InternalDataDescriptionLanguage

    // $ANTLR start synpred18_InternalDataDescriptionLanguage
    public final void synpred18_InternalDataDescriptionLanguage_fragment() throws RecognitionException {   
        EObject this_DataReferenceRule_1 = null;


        // InternalDataDescriptionLanguage.g:755:3: (this_DataReferenceRule_1= ruleDataReferenceRule )
        // InternalDataDescriptionLanguage.g:755:3: this_DataReferenceRule_1= ruleDataReferenceRule
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_DataReferenceRule_1=ruleDataReferenceRule();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_InternalDataDescriptionLanguage

    // $ANTLR start synpred30_InternalDataDescriptionLanguage
    public final void synpred30_InternalDataDescriptionLanguage_fragment() throws RecognitionException {   
        EObject this_LiteralRule_2 = null;


        // InternalDataDescriptionLanguage.g:1549:3: (this_LiteralRule_2= ruleLiteralRule )
        // InternalDataDescriptionLanguage.g:1549:3: this_LiteralRule_2= ruleLiteralRule
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_LiteralRule_2=ruleLiteralRule();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalDataDescriptionLanguage

    // Delegated rules

    public final boolean synpred18_InternalDataDescriptionLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalDataDescriptionLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalDataDescriptionLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalDataDescriptionLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalDataDescriptionLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalDataDescriptionLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\55\4\23\1\uffff\1\7\2\27\1\uffff";
    static final String dfa_3s = "\1\72\4\23\1\uffff\1\10\2\33\1\uffff";
    static final String dfa_4s = "\5\uffff\1\2\3\uffff\1\1";
    static final String dfa_5s = "\12\uffff}>";
    static final String[] dfa_6s = {
            "\1\4\3\uffff\1\3\3\uffff\4\5\1\1\1\2",
            "\1\6",
            "\1\6",
            "\1\6",
            "\1\6",
            "",
            "\1\7\1\10",
            "\1\5\2\uffff\1\5\1\11",
            "\1\5\2\uffff\1\5\1\11",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "424:2: (this_TypedDataDescriptionRule_0= ruleTypedDataDescriptionRule | this_UntypedDataDescriptionRule_1= ruleUntypedDataDescriptionRule )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000408000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000003A0000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x01E0000000380000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x07E2200000300000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000325102001F0L,0x0000000000000006L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000006800000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000325108001F0L,0x0000000000000006L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0602200000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00000325100001F0L,0x0000000000000006L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0xF800000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000038L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000335100001F0L,0x0000000000000006L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00000365100001F0L,0x0000000000000006L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004800000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000200180L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000002L,0x0000000003FFFFC0L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x000FEC0000080000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000008000800000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0010000000000002L});

}
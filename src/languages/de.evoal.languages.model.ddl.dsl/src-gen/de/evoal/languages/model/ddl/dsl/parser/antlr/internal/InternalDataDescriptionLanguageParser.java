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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_DOUBLE", "RULE_INT", "RULE_QUOTED_ID", "RULE_ID", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'module'", "'{'", "'types'", "':'", "'data'", "'constraints'", "'}'", "'type'", "'description'", "'with'", "';'", "'enum'", "'('", "','", "')'", "'of'", "'instance'", "'value'", "'OR'", "'XOR'", "'AND'", "'!'", "'^'", "'['", "']'", "':='", "'true'", "'false'", "'@'", "'literal'", "'string'", "'expression'", "'int'", "'real'", "'boolean'", "'void'", "'array'", "'import'", "'from'", "'.'", "'nominal'", "'ordinal'", "'cardinal'", "'quotient'", "'integer'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'"
    };
    public static final int T__50=50;
    public static final int T__90=90;
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
    // InternalDataDescriptionLanguage.g:79:1: ruleDataDescriptionModelRule returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'types' otherlv_5= ':' ( (lv_types_6_0= ruleDataTypeDefinitionRule ) )* )? (otherlv_7= 'data' otherlv_8= ':' ( (lv_descriptions_9_0= ruleDataDescriptionRule ) )* )? (otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )* )? otherlv_13= '}' ) ;
    public final EObject ruleDataDescriptionModelRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_imports_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_types_6_0 = null;

        EObject lv_descriptions_9_0 = null;

        EObject lv_constraints_12_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:85:2: ( ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'types' otherlv_5= ':' ( (lv_types_6_0= ruleDataTypeDefinitionRule ) )* )? (otherlv_7= 'data' otherlv_8= ':' ( (lv_descriptions_9_0= ruleDataDescriptionRule ) )* )? (otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )* )? otherlv_13= '}' ) )
            // InternalDataDescriptionLanguage.g:86:2: ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'types' otherlv_5= ':' ( (lv_types_6_0= ruleDataTypeDefinitionRule ) )* )? (otherlv_7= 'data' otherlv_8= ':' ( (lv_descriptions_9_0= ruleDataDescriptionRule ) )* )? (otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )* )? otherlv_13= '}' )
            {
            // InternalDataDescriptionLanguage.g:86:2: ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'types' otherlv_5= ':' ( (lv_types_6_0= ruleDataTypeDefinitionRule ) )* )? (otherlv_7= 'data' otherlv_8= ':' ( (lv_descriptions_9_0= ruleDataDescriptionRule ) )* )? (otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )* )? otherlv_13= '}' )
            // InternalDataDescriptionLanguage.g:87:3: ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'types' otherlv_5= ':' ( (lv_types_6_0= ruleDataTypeDefinitionRule ) )* )? (otherlv_7= 'data' otherlv_8= ':' ( (lv_descriptions_9_0= ruleDataDescriptionRule ) )* )? (otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )* )? otherlv_13= '}'
            {
            // InternalDataDescriptionLanguage.g:87:3: ( (lv_imports_0_0= ruleImportRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==52) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:88:4: (lv_imports_0_0= ruleImportRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:88:4: (lv_imports_0_0= ruleImportRule )
            	    // InternalDataDescriptionLanguage.g:89:5: lv_imports_0_0= ruleImportRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getDataDescriptionModelRuleAccess().getImportsImportRuleParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImportRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getDataDescriptionModelRuleRule());
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

              			newLeafNode(otherlv_1, grammarAccess.getDataDescriptionModelRuleAccess().getModuleKeyword_1());
              		
            }
            // InternalDataDescriptionLanguage.g:110:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:111:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalDataDescriptionLanguage.g:111:4: (lv_name_2_0= ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:112:5: lv_name_2_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDataDescriptionModelRuleAccess().getNameQualifiedNameParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDataDescriptionModelRuleRule());
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

              			newLeafNode(otherlv_3, grammarAccess.getDataDescriptionModelRuleAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalDataDescriptionLanguage.g:133:3: (otherlv_4= 'types' otherlv_5= ':' ( (lv_types_6_0= ruleDataTypeDefinitionRule ) )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:134:4: otherlv_4= 'types' otherlv_5= ':' ( (lv_types_6_0= ruleDataTypeDefinitionRule ) )*
                    {
                    otherlv_4=(Token)match(input,17,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getDataDescriptionModelRuleAccess().getTypesKeyword_4_0());
                      			
                    }
                    otherlv_5=(Token)match(input,18,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_4_1());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:142:4: ( (lv_types_6_0= ruleDataTypeDefinitionRule ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==43||(LA2_0>=55 && LA2_0<=58)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:143:5: (lv_types_6_0= ruleDataTypeDefinitionRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:143:5: (lv_types_6_0= ruleDataTypeDefinitionRule )
                    	    // InternalDataDescriptionLanguage.g:144:6: lv_types_6_0= ruleDataTypeDefinitionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getDataDescriptionModelRuleAccess().getTypesDataTypeDefinitionRuleParserRuleCall_4_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_8);
                    	    lv_types_6_0=ruleDataTypeDefinitionRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getDataDescriptionModelRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"types",
                    	      							lv_types_6_0,
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

            // InternalDataDescriptionLanguage.g:162:3: (otherlv_7= 'data' otherlv_8= ':' ( (lv_descriptions_9_0= ruleDataDescriptionRule ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:163:4: otherlv_7= 'data' otherlv_8= ':' ( (lv_descriptions_9_0= ruleDataDescriptionRule ) )*
                    {
                    otherlv_7=(Token)match(input,19,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getDataDescriptionModelRuleAccess().getDataKeyword_5_0());
                      			
                    }
                    otherlv_8=(Token)match(input,18,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_5_1());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:171:4: ( (lv_descriptions_9_0= ruleDataDescriptionRule ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==19||LA4_0==43||LA4_0==45||(LA4_0>=48 && LA4_0<=49)||(LA4_0>=55 && LA4_0<=59)) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:172:5: (lv_descriptions_9_0= ruleDataDescriptionRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:172:5: (lv_descriptions_9_0= ruleDataDescriptionRule )
                    	    // InternalDataDescriptionLanguage.g:173:6: lv_descriptions_9_0= ruleDataDescriptionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getDataDescriptionModelRuleAccess().getDescriptionsDataDescriptionRuleParserRuleCall_5_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_9);
                    	    lv_descriptions_9_0=ruleDataDescriptionRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getDataDescriptionModelRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"descriptions",
                    	      							lv_descriptions_9_0,
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

            // InternalDataDescriptionLanguage.g:191:3: (otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:192:4: otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )*
                    {
                    otherlv_10=(Token)match(input,20,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsKeyword_6_0());
                      			
                    }
                    otherlv_11=(Token)match(input,18,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_6_1());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:200:4: ( (lv_constraints_12_0= ruleStatementRule ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=RULE_STRING && LA6_0<=RULE_ID)||LA6_0==19||LA6_0==27||LA6_0==32||LA6_0==36||LA6_0==38||(LA6_0>=41 && LA6_0<=42)||(LA6_0>=66 && LA6_0<=67)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:201:5: (lv_constraints_12_0= ruleStatementRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:201:5: (lv_constraints_12_0= ruleStatementRule )
                    	    // InternalDataDescriptionLanguage.g:202:6: lv_constraints_12_0= ruleStatementRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsStatementRuleParserRuleCall_6_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_10);
                    	    lv_constraints_12_0=ruleStatementRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getDataDescriptionModelRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"constraints",
                    	      							lv_constraints_12_0,
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

            otherlv_13=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_13, grammarAccess.getDataDescriptionModelRuleAccess().getRightCurlyBracketKeyword_7());
              		
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


    // $ANTLR start "entryRuleDataTypeDefinitionRule"
    // InternalDataDescriptionLanguage.g:228:1: entryRuleDataTypeDefinitionRule returns [EObject current=null] : iv_ruleDataTypeDefinitionRule= ruleDataTypeDefinitionRule EOF ;
    public final EObject entryRuleDataTypeDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeDefinitionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:228:63: (iv_ruleDataTypeDefinitionRule= ruleDataTypeDefinitionRule EOF )
            // InternalDataDescriptionLanguage.g:229:2: iv_ruleDataTypeDefinitionRule= ruleDataTypeDefinitionRule EOF
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
    // InternalDataDescriptionLanguage.g:235:1: ruleDataTypeDefinitionRule returns [EObject current=null] : (this_BaseDataTypeDefinitionRule_0= ruleBaseDataTypeDefinitionRule | this_EnumTypeDefinitionRule_1= ruleEnumTypeDefinitionRule ) ;
    public final EObject ruleDataTypeDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject this_BaseDataTypeDefinitionRule_0 = null;

        EObject this_EnumTypeDefinitionRule_1 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:241:2: ( (this_BaseDataTypeDefinitionRule_0= ruleBaseDataTypeDefinitionRule | this_EnumTypeDefinitionRule_1= ruleEnumTypeDefinitionRule ) )
            // InternalDataDescriptionLanguage.g:242:2: (this_BaseDataTypeDefinitionRule_0= ruleBaseDataTypeDefinitionRule | this_EnumTypeDefinitionRule_1= ruleEnumTypeDefinitionRule )
            {
            // InternalDataDescriptionLanguage.g:242:2: (this_BaseDataTypeDefinitionRule_0= ruleBaseDataTypeDefinitionRule | this_EnumTypeDefinitionRule_1= ruleEnumTypeDefinitionRule )
            int alt8=2;
            switch ( input.LA(1) ) {
            case 43:
                {
                int LA8_1 = input.LA(2);

                if ( (synpred8_InternalDataDescriptionLanguage()) ) {
                    alt8=1;
                }
                else if ( (true) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
                }
                break;
            case 55:
                {
                int LA8_2 = input.LA(2);

                if ( (synpred8_InternalDataDescriptionLanguage()) ) {
                    alt8=1;
                }
                else if ( (true) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 2, input);

                    throw nvae;
                }
                }
                break;
            case 56:
                {
                int LA8_3 = input.LA(2);

                if ( (synpred8_InternalDataDescriptionLanguage()) ) {
                    alt8=1;
                }
                else if ( (true) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 3, input);

                    throw nvae;
                }
                }
                break;
            case 57:
                {
                int LA8_4 = input.LA(2);

                if ( (synpred8_InternalDataDescriptionLanguage()) ) {
                    alt8=1;
                }
                else if ( (true) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 4, input);

                    throw nvae;
                }
                }
                break;
            case 58:
                {
                int LA8_5 = input.LA(2);

                if ( (synpred8_InternalDataDescriptionLanguage()) ) {
                    alt8=1;
                }
                else if ( (true) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:243:3: this_BaseDataTypeDefinitionRule_0= ruleBaseDataTypeDefinitionRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataTypeDefinitionRuleAccess().getBaseDataTypeDefinitionRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BaseDataTypeDefinitionRule_0=ruleBaseDataTypeDefinitionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BaseDataTypeDefinitionRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:255:3: this_EnumTypeDefinitionRule_1= ruleEnumTypeDefinitionRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataTypeDefinitionRuleAccess().getEnumTypeDefinitionRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EnumTypeDefinitionRule_1=ruleEnumTypeDefinitionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EnumTypeDefinitionRule_1;
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
    // $ANTLR end "ruleDataTypeDefinitionRule"


    // $ANTLR start "entryRuleBaseDataTypeDefinitionRule"
    // InternalDataDescriptionLanguage.g:270:1: entryRuleBaseDataTypeDefinitionRule returns [EObject current=null] : iv_ruleBaseDataTypeDefinitionRule= ruleBaseDataTypeDefinitionRule EOF ;
    public final EObject entryRuleBaseDataTypeDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseDataTypeDefinitionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:270:67: (iv_ruleBaseDataTypeDefinitionRule= ruleBaseDataTypeDefinitionRule EOF )
            // InternalDataDescriptionLanguage.g:271:2: iv_ruleBaseDataTypeDefinitionRule= ruleBaseDataTypeDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBaseDataTypeDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBaseDataTypeDefinitionRule=ruleBaseDataTypeDefinitionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBaseDataTypeDefinitionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBaseDataTypeDefinitionRule"


    // $ANTLR start "ruleBaseDataTypeDefinitionRule"
    // InternalDataDescriptionLanguage.g:277:1: ruleBaseDataTypeDefinitionRule returns [EObject current=null] : ( ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) ) otherlv_2= 'type' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'description' otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? (otherlv_7= 'with' otherlv_8= 'constraints' otherlv_9= ':' ( (lv_constraints_10_0= ruleStatementRule ) )* )? otherlv_11= ';' ) ;
    public final EObject ruleBaseDataTypeDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_description_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_constraints2_0_0 = null;

        Enumerator lv_scale_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_constraints_10_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:283:2: ( ( ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) ) otherlv_2= 'type' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'description' otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? (otherlv_7= 'with' otherlv_8= 'constraints' otherlv_9= ':' ( (lv_constraints_10_0= ruleStatementRule ) )* )? otherlv_11= ';' ) )
            // InternalDataDescriptionLanguage.g:284:2: ( ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) ) otherlv_2= 'type' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'description' otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? (otherlv_7= 'with' otherlv_8= 'constraints' otherlv_9= ':' ( (lv_constraints_10_0= ruleStatementRule ) )* )? otherlv_11= ';' )
            {
            // InternalDataDescriptionLanguage.g:284:2: ( ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) ) otherlv_2= 'type' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'description' otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? (otherlv_7= 'with' otherlv_8= 'constraints' otherlv_9= ':' ( (lv_constraints_10_0= ruleStatementRule ) )* )? otherlv_11= ';' )
            // InternalDataDescriptionLanguage.g:285:3: ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) ) otherlv_2= 'type' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'description' otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? (otherlv_7= 'with' otherlv_8= 'constraints' otherlv_9= ':' ( (lv_constraints_10_0= ruleStatementRule ) )* )? otherlv_11= ';'
            {
            // InternalDataDescriptionLanguage.g:285:3: ( (lv_constraints2_0_0= ruleConstraintRule ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==43) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:286:4: (lv_constraints2_0_0= ruleConstraintRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:286:4: (lv_constraints2_0_0= ruleConstraintRule )
            	    // InternalDataDescriptionLanguage.g:287:5: lv_constraints2_0_0= ruleConstraintRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getBaseDataTypeDefinitionRuleAccess().getConstraints2ConstraintRuleParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_constraints2_0_0=ruleConstraintRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getBaseDataTypeDefinitionRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"constraints2",
            	      						lv_constraints2_0_0,
            	      						"de.evoal.languages.model.base.dsl.BaseLanguage.ConstraintRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // InternalDataDescriptionLanguage.g:304:3: ( (lv_scale_1_0= ruleScaleType ) )
            // InternalDataDescriptionLanguage.g:305:4: (lv_scale_1_0= ruleScaleType )
            {
            // InternalDataDescriptionLanguage.g:305:4: (lv_scale_1_0= ruleScaleType )
            // InternalDataDescriptionLanguage.g:306:5: lv_scale_1_0= ruleScaleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBaseDataTypeDefinitionRuleAccess().getScaleScaleTypeEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_12);
            lv_scale_1_0=ruleScaleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBaseDataTypeDefinitionRuleRule());
              					}
              					set(
              						current,
              						"scale",
              						lv_scale_1_0,
              						"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.ScaleType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getBaseDataTypeDefinitionRuleAccess().getTypeKeyword_2());
              		
            }
            // InternalDataDescriptionLanguage.g:327:3: ( (lv_name_3_0= ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:328:4: (lv_name_3_0= ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:328:4: (lv_name_3_0= ruleStringOrId )
            // InternalDataDescriptionLanguage.g:329:5: lv_name_3_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBaseDataTypeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_name_3_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBaseDataTypeDefinitionRuleRule());
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

            // InternalDataDescriptionLanguage.g:346:3: (otherlv_4= 'description' otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==23) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:347:4: otherlv_4= 'description' otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getBaseDataTypeDefinitionRuleAccess().getDescriptionKeyword_4_0());
                      			
                    }
                    otherlv_5=(Token)match(input,18,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getBaseDataTypeDefinitionRuleAccess().getColonKeyword_4_1());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:355:4: ( (lv_description_6_0= RULE_STRING ) )
                    // InternalDataDescriptionLanguage.g:356:5: (lv_description_6_0= RULE_STRING )
                    {
                    // InternalDataDescriptionLanguage.g:356:5: (lv_description_6_0= RULE_STRING )
                    // InternalDataDescriptionLanguage.g:357:6: lv_description_6_0= RULE_STRING
                    {
                    lv_description_6_0=(Token)match(input,RULE_STRING,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_description_6_0, grammarAccess.getBaseDataTypeDefinitionRuleAccess().getDescriptionSTRINGTerminalRuleCall_4_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBaseDataTypeDefinitionRuleRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"description",
                      							lv_description_6_0,
                      							"de.evoal.languages.model.base.dsl.BaseLanguage.STRING");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalDataDescriptionLanguage.g:374:3: (otherlv_7= 'with' otherlv_8= 'constraints' otherlv_9= ':' ( (lv_constraints_10_0= ruleStatementRule ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==24) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:375:4: otherlv_7= 'with' otherlv_8= 'constraints' otherlv_9= ':' ( (lv_constraints_10_0= ruleStatementRule ) )*
                    {
                    otherlv_7=(Token)match(input,24,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getBaseDataTypeDefinitionRuleAccess().getWithKeyword_5_0());
                      			
                    }
                    otherlv_8=(Token)match(input,20,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getBaseDataTypeDefinitionRuleAccess().getConstraintsKeyword_5_1());
                      			
                    }
                    otherlv_9=(Token)match(input,18,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getBaseDataTypeDefinitionRuleAccess().getColonKeyword_5_2());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:387:4: ( (lv_constraints_10_0= ruleStatementRule ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>=RULE_STRING && LA11_0<=RULE_ID)||LA11_0==19||LA11_0==27||LA11_0==32||LA11_0==36||LA11_0==38||(LA11_0>=41 && LA11_0<=42)||(LA11_0>=66 && LA11_0<=67)) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:388:5: (lv_constraints_10_0= ruleStatementRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:388:5: (lv_constraints_10_0= ruleStatementRule )
                    	    // InternalDataDescriptionLanguage.g:389:6: lv_constraints_10_0= ruleStatementRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getBaseDataTypeDefinitionRuleAccess().getConstraintsStatementRuleParserRuleCall_5_3_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_17);
                    	    lv_constraints_10_0=ruleStatementRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getBaseDataTypeDefinitionRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"constraints",
                    	      							lv_constraints_10_0,
                    	      							"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.StatementRule");
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

            otherlv_11=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_11, grammarAccess.getBaseDataTypeDefinitionRuleAccess().getSemicolonKeyword_6());
              		
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
    // $ANTLR end "ruleBaseDataTypeDefinitionRule"


    // $ANTLR start "entryRuleEnumLiteralRule"
    // InternalDataDescriptionLanguage.g:415:1: entryRuleEnumLiteralRule returns [EObject current=null] : iv_ruleEnumLiteralRule= ruleEnumLiteralRule EOF ;
    public final EObject entryRuleEnumLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:415:56: (iv_ruleEnumLiteralRule= ruleEnumLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:416:2: iv_ruleEnumLiteralRule= ruleEnumLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:422:1: ruleEnumLiteralRule returns [EObject current=null] : ( (lv_name_0_0= ruleStringOrId ) ) ;
    public final EObject ruleEnumLiteralRule() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:428:2: ( ( (lv_name_0_0= ruleStringOrId ) ) )
            // InternalDataDescriptionLanguage.g:429:2: ( (lv_name_0_0= ruleStringOrId ) )
            {
            // InternalDataDescriptionLanguage.g:429:2: ( (lv_name_0_0= ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:430:3: (lv_name_0_0= ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:430:3: (lv_name_0_0= ruleStringOrId )
            // InternalDataDescriptionLanguage.g:431:4: lv_name_0_0= ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:451:1: entryRuleEnumTypeDefinitionRule returns [EObject current=null] : iv_ruleEnumTypeDefinitionRule= ruleEnumTypeDefinitionRule EOF ;
    public final EObject entryRuleEnumTypeDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumTypeDefinitionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:451:63: (iv_ruleEnumTypeDefinitionRule= ruleEnumTypeDefinitionRule EOF )
            // InternalDataDescriptionLanguage.g:452:2: iv_ruleEnumTypeDefinitionRule= ruleEnumTypeDefinitionRule EOF
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
    // InternalDataDescriptionLanguage.g:458:1: ruleEnumTypeDefinitionRule returns [EObject current=null] : ( ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) ) otherlv_2= 'enum' ( (lv_name_3_0= ruleStringOrId ) ) otherlv_4= '(' ( (lv_literals_5_0= ruleEnumLiteralRule ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralRule ) ) )* otherlv_8= ')' (otherlv_9= 'description' otherlv_10= ':' ( (lv_description_11_0= RULE_STRING ) ) )? (otherlv_12= 'with' otherlv_13= 'constraints' otherlv_14= ':' ( (lv_constraints_15_0= ruleStatementRule ) )* )? otherlv_16= ';' ) ;
    public final EObject ruleEnumTypeDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_description_11_0=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject lv_constraints2_0_0 = null;

        Enumerator lv_scale_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_literals_5_0 = null;

        EObject lv_literals_7_0 = null;

        EObject lv_constraints_15_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:464:2: ( ( ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) ) otherlv_2= 'enum' ( (lv_name_3_0= ruleStringOrId ) ) otherlv_4= '(' ( (lv_literals_5_0= ruleEnumLiteralRule ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralRule ) ) )* otherlv_8= ')' (otherlv_9= 'description' otherlv_10= ':' ( (lv_description_11_0= RULE_STRING ) ) )? (otherlv_12= 'with' otherlv_13= 'constraints' otherlv_14= ':' ( (lv_constraints_15_0= ruleStatementRule ) )* )? otherlv_16= ';' ) )
            // InternalDataDescriptionLanguage.g:465:2: ( ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) ) otherlv_2= 'enum' ( (lv_name_3_0= ruleStringOrId ) ) otherlv_4= '(' ( (lv_literals_5_0= ruleEnumLiteralRule ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralRule ) ) )* otherlv_8= ')' (otherlv_9= 'description' otherlv_10= ':' ( (lv_description_11_0= RULE_STRING ) ) )? (otherlv_12= 'with' otherlv_13= 'constraints' otherlv_14= ':' ( (lv_constraints_15_0= ruleStatementRule ) )* )? otherlv_16= ';' )
            {
            // InternalDataDescriptionLanguage.g:465:2: ( ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) ) otherlv_2= 'enum' ( (lv_name_3_0= ruleStringOrId ) ) otherlv_4= '(' ( (lv_literals_5_0= ruleEnumLiteralRule ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralRule ) ) )* otherlv_8= ')' (otherlv_9= 'description' otherlv_10= ':' ( (lv_description_11_0= RULE_STRING ) ) )? (otherlv_12= 'with' otherlv_13= 'constraints' otherlv_14= ':' ( (lv_constraints_15_0= ruleStatementRule ) )* )? otherlv_16= ';' )
            // InternalDataDescriptionLanguage.g:466:3: ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) ) otherlv_2= 'enum' ( (lv_name_3_0= ruleStringOrId ) ) otherlv_4= '(' ( (lv_literals_5_0= ruleEnumLiteralRule ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralRule ) ) )* otherlv_8= ')' (otherlv_9= 'description' otherlv_10= ':' ( (lv_description_11_0= RULE_STRING ) ) )? (otherlv_12= 'with' otherlv_13= 'constraints' otherlv_14= ':' ( (lv_constraints_15_0= ruleStatementRule ) )* )? otherlv_16= ';'
            {
            // InternalDataDescriptionLanguage.g:466:3: ( (lv_constraints2_0_0= ruleConstraintRule ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==43) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:467:4: (lv_constraints2_0_0= ruleConstraintRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:467:4: (lv_constraints2_0_0= ruleConstraintRule )
            	    // InternalDataDescriptionLanguage.g:468:5: lv_constraints2_0_0= ruleConstraintRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraints2ConstraintRuleParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_constraints2_0_0=ruleConstraintRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getEnumTypeDefinitionRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"constraints2",
            	      						lv_constraints2_0_0,
            	      						"de.evoal.languages.model.base.dsl.BaseLanguage.ConstraintRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // InternalDataDescriptionLanguage.g:485:3: ( (lv_scale_1_0= ruleScaleType ) )
            // InternalDataDescriptionLanguage.g:486:4: (lv_scale_1_0= ruleScaleType )
            {
            // InternalDataDescriptionLanguage.g:486:4: (lv_scale_1_0= ruleScaleType )
            // InternalDataDescriptionLanguage.g:487:5: lv_scale_1_0= ruleScaleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumTypeDefinitionRuleAccess().getScaleScaleTypeEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_18);
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
              						"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.ScaleType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEnumTypeDefinitionRuleAccess().getEnumKeyword_2());
              		
            }
            // InternalDataDescriptionLanguage.g:508:3: ( (lv_name_3_0= ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:509:4: (lv_name_3_0= ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:509:4: (lv_name_3_0= ruleStringOrId )
            // InternalDataDescriptionLanguage.g:510:5: lv_name_3_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumTypeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_19);
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

            otherlv_4=(Token)match(input,27,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getEnumTypeDefinitionRuleAccess().getLeftParenthesisKeyword_4());
              		
            }
            // InternalDataDescriptionLanguage.g:531:3: ( (lv_literals_5_0= ruleEnumLiteralRule ) )
            // InternalDataDescriptionLanguage.g:532:4: (lv_literals_5_0= ruleEnumLiteralRule )
            {
            // InternalDataDescriptionLanguage.g:532:4: (lv_literals_5_0= ruleEnumLiteralRule )
            // InternalDataDescriptionLanguage.g:533:5: lv_literals_5_0= ruleEnumLiteralRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumTypeDefinitionRuleAccess().getLiteralsEnumLiteralRuleParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_20);
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
              						"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.EnumLiteralRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalDataDescriptionLanguage.g:550:3: (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralRule ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==28) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:551:4: otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralRule ) )
            	    {
            	    otherlv_6=(Token)match(input,28,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_6, grammarAccess.getEnumTypeDefinitionRuleAccess().getCommaKeyword_6_0());
            	      			
            	    }
            	    // InternalDataDescriptionLanguage.g:555:4: ( (lv_literals_7_0= ruleEnumLiteralRule ) )
            	    // InternalDataDescriptionLanguage.g:556:5: (lv_literals_7_0= ruleEnumLiteralRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:556:5: (lv_literals_7_0= ruleEnumLiteralRule )
            	    // InternalDataDescriptionLanguage.g:557:6: lv_literals_7_0= ruleEnumLiteralRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEnumTypeDefinitionRuleAccess().getLiteralsEnumLiteralRuleParserRuleCall_6_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
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
            	      							"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.EnumLiteralRule");
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

            otherlv_8=(Token)match(input,29,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getEnumTypeDefinitionRuleAccess().getRightParenthesisKeyword_7());
              		
            }
            // InternalDataDescriptionLanguage.g:579:3: (otherlv_9= 'description' otherlv_10= ':' ( (lv_description_11_0= RULE_STRING ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:580:4: otherlv_9= 'description' otherlv_10= ':' ( (lv_description_11_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,23,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getEnumTypeDefinitionRuleAccess().getDescriptionKeyword_8_0());
                      			
                    }
                    otherlv_10=(Token)match(input,18,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getEnumTypeDefinitionRuleAccess().getColonKeyword_8_1());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:588:4: ( (lv_description_11_0= RULE_STRING ) )
                    // InternalDataDescriptionLanguage.g:589:5: (lv_description_11_0= RULE_STRING )
                    {
                    // InternalDataDescriptionLanguage.g:589:5: (lv_description_11_0= RULE_STRING )
                    // InternalDataDescriptionLanguage.g:590:6: lv_description_11_0= RULE_STRING
                    {
                    lv_description_11_0=(Token)match(input,RULE_STRING,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_description_11_0, grammarAccess.getEnumTypeDefinitionRuleAccess().getDescriptionSTRINGTerminalRuleCall_8_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getEnumTypeDefinitionRuleRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"description",
                      							lv_description_11_0,
                      							"de.evoal.languages.model.base.dsl.BaseLanguage.STRING");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalDataDescriptionLanguage.g:607:3: (otherlv_12= 'with' otherlv_13= 'constraints' otherlv_14= ':' ( (lv_constraints_15_0= ruleStatementRule ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==24) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:608:4: otherlv_12= 'with' otherlv_13= 'constraints' otherlv_14= ':' ( (lv_constraints_15_0= ruleStatementRule ) )*
                    {
                    otherlv_12=(Token)match(input,24,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getEnumTypeDefinitionRuleAccess().getWithKeyword_9_0());
                      			
                    }
                    otherlv_13=(Token)match(input,20,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsKeyword_9_1());
                      			
                    }
                    otherlv_14=(Token)match(input,18,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getEnumTypeDefinitionRuleAccess().getColonKeyword_9_2());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:620:4: ( (lv_constraints_15_0= ruleStatementRule ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>=RULE_STRING && LA16_0<=RULE_ID)||LA16_0==19||LA16_0==27||LA16_0==32||LA16_0==36||LA16_0==38||(LA16_0>=41 && LA16_0<=42)||(LA16_0>=66 && LA16_0<=67)) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:621:5: (lv_constraints_15_0= ruleStatementRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:621:5: (lv_constraints_15_0= ruleStatementRule )
                    	    // InternalDataDescriptionLanguage.g:622:6: lv_constraints_15_0= ruleStatementRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getEnumTypeDefinitionRuleAccess().getConstraintsStatementRuleParserRuleCall_9_3_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_17);
                    	    lv_constraints_15_0=ruleStatementRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getEnumTypeDefinitionRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"constraints",
                    	      							lv_constraints_15_0,
                    	      							"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.StatementRule");
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

            otherlv_16=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_16, grammarAccess.getEnumTypeDefinitionRuleAccess().getSemicolonKeyword_10());
              		
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


    // $ANTLR start "entryRuleDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:648:1: entryRuleDataDescriptionRule returns [EObject current=null] : iv_ruleDataDescriptionRule= ruleDataDescriptionRule EOF ;
    public final EObject entryRuleDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataDescriptionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:648:60: (iv_ruleDataDescriptionRule= ruleDataDescriptionRule EOF )
            // InternalDataDescriptionLanguage.g:649:2: iv_ruleDataDescriptionRule= ruleDataDescriptionRule EOF
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
    // InternalDataDescriptionLanguage.g:655:1: ruleDataDescriptionRule returns [EObject current=null] : (this_TypedBaseDataDescriptionRule_0= ruleTypedBaseDataDescriptionRule | this_UntypedBaseDataDescriptionRule_1= ruleUntypedBaseDataDescriptionRule | this_StructuredDataDescriptionRule_2= ruleStructuredDataDescriptionRule ) ;
    public final EObject ruleDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        EObject this_TypedBaseDataDescriptionRule_0 = null;

        EObject this_UntypedBaseDataDescriptionRule_1 = null;

        EObject this_StructuredDataDescriptionRule_2 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:661:2: ( (this_TypedBaseDataDescriptionRule_0= ruleTypedBaseDataDescriptionRule | this_UntypedBaseDataDescriptionRule_1= ruleUntypedBaseDataDescriptionRule | this_StructuredDataDescriptionRule_2= ruleStructuredDataDescriptionRule ) )
            // InternalDataDescriptionLanguage.g:662:2: (this_TypedBaseDataDescriptionRule_0= ruleTypedBaseDataDescriptionRule | this_UntypedBaseDataDescriptionRule_1= ruleUntypedBaseDataDescriptionRule | this_StructuredDataDescriptionRule_2= ruleStructuredDataDescriptionRule )
            {
            // InternalDataDescriptionLanguage.g:662:2: (this_TypedBaseDataDescriptionRule_0= ruleTypedBaseDataDescriptionRule | this_UntypedBaseDataDescriptionRule_1= ruleUntypedBaseDataDescriptionRule | this_StructuredDataDescriptionRule_2= ruleStructuredDataDescriptionRule )
            int alt18=3;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:663:3: this_TypedBaseDataDescriptionRule_0= ruleTypedBaseDataDescriptionRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataDescriptionRuleAccess().getTypedBaseDataDescriptionRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypedBaseDataDescriptionRule_0=ruleTypedBaseDataDescriptionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypedBaseDataDescriptionRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:675:3: this_UntypedBaseDataDescriptionRule_1= ruleUntypedBaseDataDescriptionRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataDescriptionRuleAccess().getUntypedBaseDataDescriptionRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_UntypedBaseDataDescriptionRule_1=ruleUntypedBaseDataDescriptionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UntypedBaseDataDescriptionRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:687:3: this_StructuredDataDescriptionRule_2= ruleStructuredDataDescriptionRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataDescriptionRuleAccess().getStructuredDataDescriptionRuleParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StructuredDataDescriptionRule_2=ruleStructuredDataDescriptionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StructuredDataDescriptionRule_2;
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


    // $ANTLR start "entryRuleTypedBaseDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:702:1: entryRuleTypedBaseDataDescriptionRule returns [EObject current=null] : iv_ruleTypedBaseDataDescriptionRule= ruleTypedBaseDataDescriptionRule EOF ;
    public final EObject entryRuleTypedBaseDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedBaseDataDescriptionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:702:69: (iv_ruleTypedBaseDataDescriptionRule= ruleTypedBaseDataDescriptionRule EOF )
            // InternalDataDescriptionLanguage.g:703:2: iv_ruleTypedBaseDataDescriptionRule= ruleTypedBaseDataDescriptionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedBaseDataDescriptionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypedBaseDataDescriptionRule=ruleTypedBaseDataDescriptionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedBaseDataDescriptionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedBaseDataDescriptionRule"


    // $ANTLR start "ruleTypedBaseDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:709:1: ruleTypedBaseDataDescriptionRule returns [EObject current=null] : ( ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_representation_1_0= ruleRepresentationType ) ) otherlv_2= 'data' ( (lv_name_3_0= ruleStringOrId ) ) otherlv_4= 'of' ( (otherlv_5= 'type' ( ( ruleQualifiedName ) ) ) | (otherlv_7= 'enum' ( ( ruleQualifiedName ) ) ) ) (otherlv_9= 'with' otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )* )? otherlv_13= ';' ) ;
    public final EObject ruleTypedBaseDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_constraints2_0_0 = null;

        Enumerator lv_representation_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_constraints_12_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:715:2: ( ( ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_representation_1_0= ruleRepresentationType ) ) otherlv_2= 'data' ( (lv_name_3_0= ruleStringOrId ) ) otherlv_4= 'of' ( (otherlv_5= 'type' ( ( ruleQualifiedName ) ) ) | (otherlv_7= 'enum' ( ( ruleQualifiedName ) ) ) ) (otherlv_9= 'with' otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )* )? otherlv_13= ';' ) )
            // InternalDataDescriptionLanguage.g:716:2: ( ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_representation_1_0= ruleRepresentationType ) ) otherlv_2= 'data' ( (lv_name_3_0= ruleStringOrId ) ) otherlv_4= 'of' ( (otherlv_5= 'type' ( ( ruleQualifiedName ) ) ) | (otherlv_7= 'enum' ( ( ruleQualifiedName ) ) ) ) (otherlv_9= 'with' otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )* )? otherlv_13= ';' )
            {
            // InternalDataDescriptionLanguage.g:716:2: ( ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_representation_1_0= ruleRepresentationType ) ) otherlv_2= 'data' ( (lv_name_3_0= ruleStringOrId ) ) otherlv_4= 'of' ( (otherlv_5= 'type' ( ( ruleQualifiedName ) ) ) | (otherlv_7= 'enum' ( ( ruleQualifiedName ) ) ) ) (otherlv_9= 'with' otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )* )? otherlv_13= ';' )
            // InternalDataDescriptionLanguage.g:717:3: ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_representation_1_0= ruleRepresentationType ) ) otherlv_2= 'data' ( (lv_name_3_0= ruleStringOrId ) ) otherlv_4= 'of' ( (otherlv_5= 'type' ( ( ruleQualifiedName ) ) ) | (otherlv_7= 'enum' ( ( ruleQualifiedName ) ) ) ) (otherlv_9= 'with' otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )* )? otherlv_13= ';'
            {
            // InternalDataDescriptionLanguage.g:717:3: ( (lv_constraints2_0_0= ruleConstraintRule ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==43) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:718:4: (lv_constraints2_0_0= ruleConstraintRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:718:4: (lv_constraints2_0_0= ruleConstraintRule )
            	    // InternalDataDescriptionLanguage.g:719:5: lv_constraints2_0_0= ruleConstraintRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getConstraints2ConstraintRuleParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_21);
            	    lv_constraints2_0_0=ruleConstraintRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getTypedBaseDataDescriptionRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"constraints2",
            	      						lv_constraints2_0_0,
            	      						"de.evoal.languages.model.base.dsl.BaseLanguage.ConstraintRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            // InternalDataDescriptionLanguage.g:736:3: ( (lv_representation_1_0= ruleRepresentationType ) )
            // InternalDataDescriptionLanguage.g:737:4: (lv_representation_1_0= ruleRepresentationType )
            {
            // InternalDataDescriptionLanguage.g:737:4: (lv_representation_1_0= ruleRepresentationType )
            // InternalDataDescriptionLanguage.g:738:5: lv_representation_1_0= ruleRepresentationType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getRepresentationRepresentationTypeEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_representation_1_0=ruleRepresentationType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTypedBaseDataDescriptionRuleRule());
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

              			newLeafNode(otherlv_2, grammarAccess.getTypedBaseDataDescriptionRuleAccess().getDataKeyword_2());
              		
            }
            // InternalDataDescriptionLanguage.g:759:3: ( (lv_name_3_0= ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:760:4: (lv_name_3_0= ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:760:4: (lv_name_3_0= ruleStringOrId )
            // InternalDataDescriptionLanguage.g:761:5: lv_name_3_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getNameStringOrIdParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_23);
            lv_name_3_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTypedBaseDataDescriptionRuleRule());
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

            otherlv_4=(Token)match(input,30,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getTypedBaseDataDescriptionRuleAccess().getOfKeyword_4());
              		
            }
            // InternalDataDescriptionLanguage.g:782:3: ( (otherlv_5= 'type' ( ( ruleQualifiedName ) ) ) | (otherlv_7= 'enum' ( ( ruleQualifiedName ) ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==22) ) {
                alt20=1;
            }
            else if ( (LA20_0==26) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:783:4: (otherlv_5= 'type' ( ( ruleQualifiedName ) ) )
                    {
                    // InternalDataDescriptionLanguage.g:783:4: (otherlv_5= 'type' ( ( ruleQualifiedName ) ) )
                    // InternalDataDescriptionLanguage.g:784:5: otherlv_5= 'type' ( ( ruleQualifiedName ) )
                    {
                    otherlv_5=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getTypedBaseDataDescriptionRuleAccess().getTypeKeyword_5_0_0());
                      				
                    }
                    // InternalDataDescriptionLanguage.g:788:5: ( ( ruleQualifiedName ) )
                    // InternalDataDescriptionLanguage.g:789:6: ( ruleQualifiedName )
                    {
                    // InternalDataDescriptionLanguage.g:789:6: ( ruleQualifiedName )
                    // InternalDataDescriptionLanguage.g:790:7: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      							/* */
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getTypedBaseDataDescriptionRuleRule());
                      							}
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getTypeBaseDataTypeDefinitionCrossReference_5_0_1_0());
                      						
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


                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:809:4: (otherlv_7= 'enum' ( ( ruleQualifiedName ) ) )
                    {
                    // InternalDataDescriptionLanguage.g:809:4: (otherlv_7= 'enum' ( ( ruleQualifiedName ) ) )
                    // InternalDataDescriptionLanguage.g:810:5: otherlv_7= 'enum' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,26,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getTypedBaseDataDescriptionRuleAccess().getEnumKeyword_5_1_0());
                      				
                    }
                    // InternalDataDescriptionLanguage.g:814:5: ( ( ruleQualifiedName ) )
                    // InternalDataDescriptionLanguage.g:815:6: ( ruleQualifiedName )
                    {
                    // InternalDataDescriptionLanguage.g:815:6: ( ruleQualifiedName )
                    // InternalDataDescriptionLanguage.g:816:7: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      							/* */
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getTypedBaseDataDescriptionRuleRule());
                      							}
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getTypeEnumTypeDefinitionCrossReference_5_1_1_0());
                      						
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


                    }


                    }
                    break;

            }

            // InternalDataDescriptionLanguage.g:835:3: (otherlv_9= 'with' otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==24) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:836:4: otherlv_9= 'with' otherlv_10= 'constraints' otherlv_11= ':' ( (lv_constraints_12_0= ruleStatementRule ) )*
                    {
                    otherlv_9=(Token)match(input,24,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getTypedBaseDataDescriptionRuleAccess().getWithKeyword_6_0());
                      			
                    }
                    otherlv_10=(Token)match(input,20,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getTypedBaseDataDescriptionRuleAccess().getConstraintsKeyword_6_1());
                      			
                    }
                    otherlv_11=(Token)match(input,18,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getTypedBaseDataDescriptionRuleAccess().getColonKeyword_6_2());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:848:4: ( (lv_constraints_12_0= ruleStatementRule ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( ((LA21_0>=RULE_STRING && LA21_0<=RULE_ID)||LA21_0==19||LA21_0==27||LA21_0==32||LA21_0==36||LA21_0==38||(LA21_0>=41 && LA21_0<=42)||(LA21_0>=66 && LA21_0<=67)) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:849:5: (lv_constraints_12_0= ruleStatementRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:849:5: (lv_constraints_12_0= ruleStatementRule )
                    	    // InternalDataDescriptionLanguage.g:850:6: lv_constraints_12_0= ruleStatementRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getTypedBaseDataDescriptionRuleAccess().getConstraintsStatementRuleParserRuleCall_6_3_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_17);
                    	    lv_constraints_12_0=ruleStatementRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getTypedBaseDataDescriptionRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"constraints",
                    	      							lv_constraints_12_0,
                    	      							"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.StatementRule");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_13=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_13, grammarAccess.getTypedBaseDataDescriptionRuleAccess().getSemicolonKeyword_7());
              		
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
    // $ANTLR end "ruleTypedBaseDataDescriptionRule"


    // $ANTLR start "entryRuleUntypedBaseDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:876:1: entryRuleUntypedBaseDataDescriptionRule returns [EObject current=null] : iv_ruleUntypedBaseDataDescriptionRule= ruleUntypedBaseDataDescriptionRule EOF ;
    public final EObject entryRuleUntypedBaseDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUntypedBaseDataDescriptionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:876:71: (iv_ruleUntypedBaseDataDescriptionRule= ruleUntypedBaseDataDescriptionRule EOF )
            // InternalDataDescriptionLanguage.g:877:2: iv_ruleUntypedBaseDataDescriptionRule= ruleUntypedBaseDataDescriptionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUntypedBaseDataDescriptionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUntypedBaseDataDescriptionRule=ruleUntypedBaseDataDescriptionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUntypedBaseDataDescriptionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUntypedBaseDataDescriptionRule"


    // $ANTLR start "ruleUntypedBaseDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:883:1: ruleUntypedBaseDataDescriptionRule returns [EObject current=null] : ( ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) )? ( (lv_representation_2_0= ruleRepresentationType ) ) otherlv_3= 'data' ( (lv_name_4_0= ruleStringOrId ) ) (otherlv_5= 'with' otherlv_6= 'constraints' otherlv_7= ':' ( (lv_constraints_8_0= ruleStatementRule ) )* )? otherlv_9= ';' ) ;
    public final EObject ruleUntypedBaseDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_constraints2_0_0 = null;

        Enumerator lv_scale_1_0 = null;

        Enumerator lv_representation_2_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        EObject lv_constraints_8_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:889:2: ( ( ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) )? ( (lv_representation_2_0= ruleRepresentationType ) ) otherlv_3= 'data' ( (lv_name_4_0= ruleStringOrId ) ) (otherlv_5= 'with' otherlv_6= 'constraints' otherlv_7= ':' ( (lv_constraints_8_0= ruleStatementRule ) )* )? otherlv_9= ';' ) )
            // InternalDataDescriptionLanguage.g:890:2: ( ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) )? ( (lv_representation_2_0= ruleRepresentationType ) ) otherlv_3= 'data' ( (lv_name_4_0= ruleStringOrId ) ) (otherlv_5= 'with' otherlv_6= 'constraints' otherlv_7= ':' ( (lv_constraints_8_0= ruleStatementRule ) )* )? otherlv_9= ';' )
            {
            // InternalDataDescriptionLanguage.g:890:2: ( ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) )? ( (lv_representation_2_0= ruleRepresentationType ) ) otherlv_3= 'data' ( (lv_name_4_0= ruleStringOrId ) ) (otherlv_5= 'with' otherlv_6= 'constraints' otherlv_7= ':' ( (lv_constraints_8_0= ruleStatementRule ) )* )? otherlv_9= ';' )
            // InternalDataDescriptionLanguage.g:891:3: ( (lv_constraints2_0_0= ruleConstraintRule ) )* ( (lv_scale_1_0= ruleScaleType ) )? ( (lv_representation_2_0= ruleRepresentationType ) ) otherlv_3= 'data' ( (lv_name_4_0= ruleStringOrId ) ) (otherlv_5= 'with' otherlv_6= 'constraints' otherlv_7= ':' ( (lv_constraints_8_0= ruleStatementRule ) )* )? otherlv_9= ';'
            {
            // InternalDataDescriptionLanguage.g:891:3: ( (lv_constraints2_0_0= ruleConstraintRule ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==43) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:892:4: (lv_constraints2_0_0= ruleConstraintRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:892:4: (lv_constraints2_0_0= ruleConstraintRule )
            	    // InternalDataDescriptionLanguage.g:893:5: lv_constraints2_0_0= ruleConstraintRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getConstraints2ConstraintRuleParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_25);
            	    lv_constraints2_0_0=ruleConstraintRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getUntypedBaseDataDescriptionRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"constraints2",
            	      						lv_constraints2_0_0,
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

            // InternalDataDescriptionLanguage.g:910:3: ( (lv_scale_1_0= ruleScaleType ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=55 && LA24_0<=58)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:911:4: (lv_scale_1_0= ruleScaleType )
                    {
                    // InternalDataDescriptionLanguage.g:911:4: (lv_scale_1_0= ruleScaleType )
                    // InternalDataDescriptionLanguage.g:912:5: lv_scale_1_0= ruleScaleType
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getScaleScaleTypeEnumRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_21);
                    lv_scale_1_0=ruleScaleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getUntypedBaseDataDescriptionRuleRule());
                      					}
                      					set(
                      						current,
                      						"scale",
                      						lv_scale_1_0,
                      						"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.ScaleType");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalDataDescriptionLanguage.g:929:3: ( (lv_representation_2_0= ruleRepresentationType ) )
            // InternalDataDescriptionLanguage.g:930:4: (lv_representation_2_0= ruleRepresentationType )
            {
            // InternalDataDescriptionLanguage.g:930:4: (lv_representation_2_0= ruleRepresentationType )
            // InternalDataDescriptionLanguage.g:931:5: lv_representation_2_0= ruleRepresentationType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getRepresentationRepresentationTypeEnumRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_representation_2_0=ruleRepresentationType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUntypedBaseDataDescriptionRuleRule());
              					}
              					set(
              						current,
              						"representation",
              						lv_representation_2_0,
              						"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.RepresentationType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getDataKeyword_3());
              		
            }
            // InternalDataDescriptionLanguage.g:952:3: ( (lv_name_4_0= ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:953:4: (lv_name_4_0= ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:953:4: (lv_name_4_0= ruleStringOrId )
            // InternalDataDescriptionLanguage.g:954:5: lv_name_4_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getNameStringOrIdParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_name_4_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUntypedBaseDataDescriptionRuleRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_4_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.StringOrId");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalDataDescriptionLanguage.g:971:3: (otherlv_5= 'with' otherlv_6= 'constraints' otherlv_7= ':' ( (lv_constraints_8_0= ruleStatementRule ) )* )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==24) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:972:4: otherlv_5= 'with' otherlv_6= 'constraints' otherlv_7= ':' ( (lv_constraints_8_0= ruleStatementRule ) )*
                    {
                    otherlv_5=(Token)match(input,24,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getWithKeyword_5_0());
                      			
                    }
                    otherlv_6=(Token)match(input,20,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getConstraintsKeyword_5_1());
                      			
                    }
                    otherlv_7=(Token)match(input,18,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getColonKeyword_5_2());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:984:4: ( (lv_constraints_8_0= ruleStatementRule ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0>=RULE_STRING && LA25_0<=RULE_ID)||LA25_0==19||LA25_0==27||LA25_0==32||LA25_0==36||LA25_0==38||(LA25_0>=41 && LA25_0<=42)||(LA25_0>=66 && LA25_0<=67)) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:985:5: (lv_constraints_8_0= ruleStatementRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:985:5: (lv_constraints_8_0= ruleStatementRule )
                    	    // InternalDataDescriptionLanguage.g:986:6: lv_constraints_8_0= ruleStatementRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getConstraintsStatementRuleParserRuleCall_5_3_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_17);
                    	    lv_constraints_8_0=ruleStatementRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getUntypedBaseDataDescriptionRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"constraints",
                    	      							lv_constraints_8_0,
                    	      							"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.StatementRule");
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
                    break;

            }

            otherlv_9=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getUntypedBaseDataDescriptionRuleAccess().getSemicolonKeyword_6());
              		
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
    // $ANTLR end "ruleUntypedBaseDataDescriptionRule"


    // $ANTLR start "entryRuleStructuredDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:1012:1: entryRuleStructuredDataDescriptionRule returns [EObject current=null] : iv_ruleStructuredDataDescriptionRule= ruleStructuredDataDescriptionRule EOF ;
    public final EObject entryRuleStructuredDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredDataDescriptionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1012:70: (iv_ruleStructuredDataDescriptionRule= ruleStructuredDataDescriptionRule EOF )
            // InternalDataDescriptionLanguage.g:1013:2: iv_ruleStructuredDataDescriptionRule= ruleStructuredDataDescriptionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStructuredDataDescriptionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStructuredDataDescriptionRule=ruleStructuredDataDescriptionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStructuredDataDescriptionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStructuredDataDescriptionRule"


    // $ANTLR start "ruleStructuredDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:1019:1: ruleStructuredDataDescriptionRule returns [EObject current=null] : (otherlv_0= 'data' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'of' otherlv_3= 'instance' ( ( ruleQualifiedName ) ) otherlv_5= ';' ) ;
    public final EObject ruleStructuredDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1025:2: ( (otherlv_0= 'data' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'of' otherlv_3= 'instance' ( ( ruleQualifiedName ) ) otherlv_5= ';' ) )
            // InternalDataDescriptionLanguage.g:1026:2: (otherlv_0= 'data' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'of' otherlv_3= 'instance' ( ( ruleQualifiedName ) ) otherlv_5= ';' )
            {
            // InternalDataDescriptionLanguage.g:1026:2: (otherlv_0= 'data' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'of' otherlv_3= 'instance' ( ( ruleQualifiedName ) ) otherlv_5= ';' )
            // InternalDataDescriptionLanguage.g:1027:3: otherlv_0= 'data' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= 'of' otherlv_3= 'instance' ( ( ruleQualifiedName ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStructuredDataDescriptionRuleAccess().getDataKeyword_0());
              		
            }
            // InternalDataDescriptionLanguage.g:1031:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:1032:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:1032:4: (lv_name_1_0= ruleStringOrId )
            // InternalDataDescriptionLanguage.g:1033:5: lv_name_1_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStructuredDataDescriptionRuleAccess().getNameStringOrIdParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_23);
            lv_name_1_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getStructuredDataDescriptionRuleRule());
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

            otherlv_2=(Token)match(input,30,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getStructuredDataDescriptionRuleAccess().getOfKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,31,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getStructuredDataDescriptionRuleAccess().getInstanceKeyword_3());
              		
            }
            // InternalDataDescriptionLanguage.g:1058:3: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:1059:4: ( ruleQualifiedName )
            {
            // InternalDataDescriptionLanguage.g:1059:4: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:1060:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStructuredDataDescriptionRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStructuredDataDescriptionRuleAccess().getTypeTypeDefinitionCrossReference_4_0());
              				
            }
            pushFollow(FOLLOW_27);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getStructuredDataDescriptionRuleAccess().getSemicolonKeyword_5());
              		
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
    // $ANTLR end "ruleStructuredDataDescriptionRule"


    // $ANTLR start "entryRuleStatementRule"
    // InternalDataDescriptionLanguage.g:1085:1: entryRuleStatementRule returns [EObject current=null] : iv_ruleStatementRule= ruleStatementRule EOF ;
    public final EObject entryRuleStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1085:54: (iv_ruleStatementRule= ruleStatementRule EOF )
            // InternalDataDescriptionLanguage.g:1086:2: iv_ruleStatementRule= ruleStatementRule EOF
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
    // InternalDataDescriptionLanguage.g:1092:1: ruleStatementRule returns [EObject current=null] : (this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';' ) ;
    public final EObject ruleStatementRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_ExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1098:2: ( (this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';' ) )
            // InternalDataDescriptionLanguage.g:1099:2: (this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';' )
            {
            // InternalDataDescriptionLanguage.g:1099:2: (this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';' )
            // InternalDataDescriptionLanguage.g:1100:3: this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';'
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getStatementRuleAccess().getExpressionRuleParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_27);
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


    // $ANTLR start "entryRuleReferenceRule"
    // InternalDataDescriptionLanguage.g:1119:1: entryRuleReferenceRule returns [EObject current=null] : iv_ruleReferenceRule= ruleReferenceRule EOF ;
    public final EObject entryRuleReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1119:54: (iv_ruleReferenceRule= ruleReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:1120:2: iv_ruleReferenceRule= ruleReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:1126:1: ruleReferenceRule returns [EObject current=null] : (this_ConstantReferenceRule_0= ruleConstantReferenceRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_SelfReferenceRule_2= ruleSelfReferenceRule ) ;
    public final EObject ruleReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_ConstantReferenceRule_0 = null;

        EObject this_DataReferenceRule_1 = null;

        EObject this_SelfReferenceRule_2 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1132:2: ( (this_ConstantReferenceRule_0= ruleConstantReferenceRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_SelfReferenceRule_2= ruleSelfReferenceRule ) )
            // InternalDataDescriptionLanguage.g:1133:2: (this_ConstantReferenceRule_0= ruleConstantReferenceRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_SelfReferenceRule_2= ruleSelfReferenceRule )
            {
            // InternalDataDescriptionLanguage.g:1133:2: (this_ConstantReferenceRule_0= ruleConstantReferenceRule | this_DataReferenceRule_1= ruleDataReferenceRule | this_SelfReferenceRule_2= ruleSelfReferenceRule )
            int alt27=3;
            switch ( input.LA(1) ) {
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt27=1;
                }
                break;
            case 19:
                {
                alt27=2;
                }
                break;
            case 32:
                {
                alt27=3;
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
                    // InternalDataDescriptionLanguage.g:1134:3: this_ConstantReferenceRule_0= ruleConstantReferenceRule
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
                    // InternalDataDescriptionLanguage.g:1146:3: this_DataReferenceRule_1= ruleDataReferenceRule
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
                    // InternalDataDescriptionLanguage.g:1158:3: this_SelfReferenceRule_2= ruleSelfReferenceRule
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
    // InternalDataDescriptionLanguage.g:1173:1: entryRuleDataReferenceRule returns [EObject current=null] : iv_ruleDataReferenceRule= ruleDataReferenceRule EOF ;
    public final EObject entryRuleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataReferenceRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1173:58: (iv_ruleDataReferenceRule= ruleDataReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:1174:2: iv_ruleDataReferenceRule= ruleDataReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:1180:1: ruleDataReferenceRule returns [EObject current=null] : (otherlv_0= 'data' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1186:2: ( (otherlv_0= 'data' ( ( ruleQualifiedName ) ) ) )
            // InternalDataDescriptionLanguage.g:1187:2: (otherlv_0= 'data' ( ( ruleQualifiedName ) ) )
            {
            // InternalDataDescriptionLanguage.g:1187:2: (otherlv_0= 'data' ( ( ruleQualifiedName ) ) )
            // InternalDataDescriptionLanguage.g:1188:3: otherlv_0= 'data' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDataReferenceRuleAccess().getDataKeyword_0());
              		
            }
            // InternalDataDescriptionLanguage.g:1192:3: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:1193:4: ( ruleQualifiedName )
            {
            // InternalDataDescriptionLanguage.g:1193:4: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:1194:5: ruleQualifiedName
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


    // $ANTLR start "entryRuleSelfReferenceRule"
    // InternalDataDescriptionLanguage.g:1215:1: entryRuleSelfReferenceRule returns [EObject current=null] : iv_ruleSelfReferenceRule= ruleSelfReferenceRule EOF ;
    public final EObject entryRuleSelfReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfReferenceRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1215:58: (iv_ruleSelfReferenceRule= ruleSelfReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:1216:2: iv_ruleSelfReferenceRule= ruleSelfReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:1222:1: ruleSelfReferenceRule returns [EObject current=null] : ( () otherlv_1= 'value' ) ;
    public final EObject ruleSelfReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1228:2: ( ( () otherlv_1= 'value' ) )
            // InternalDataDescriptionLanguage.g:1229:2: ( () otherlv_1= 'value' )
            {
            // InternalDataDescriptionLanguage.g:1229:2: ( () otherlv_1= 'value' )
            // InternalDataDescriptionLanguage.g:1230:3: () otherlv_1= 'value'
            {
            // InternalDataDescriptionLanguage.g:1230:3: ()
            // InternalDataDescriptionLanguage.g:1231:4: 
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

            otherlv_1=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleEnumLiteralReferenceRule"
    // InternalDataDescriptionLanguage.g:1248:1: entryRuleEnumLiteralReferenceRule returns [EObject current=null] : iv_ruleEnumLiteralReferenceRule= ruleEnumLiteralReferenceRule EOF ;
    public final EObject entryRuleEnumLiteralReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteralReferenceRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1248:65: (iv_ruleEnumLiteralReferenceRule= ruleEnumLiteralReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:1249:2: iv_ruleEnumLiteralReferenceRule= ruleEnumLiteralReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumLiteralReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumLiteralReferenceRule=ruleEnumLiteralReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumLiteralReferenceRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumLiteralReferenceRule"


    // $ANTLR start "ruleEnumLiteralReferenceRule"
    // InternalDataDescriptionLanguage.g:1255:1: ruleEnumLiteralReferenceRule returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleEnumLiteralReferenceRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1261:2: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDescriptionLanguage.g:1262:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDescriptionLanguage.g:1262:2: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:1263:3: ( ruleQualifiedName )
            {
            // InternalDataDescriptionLanguage.g:1263:3: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:1264:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getEnumLiteralReferenceRuleRule());
              				}
              			
            }
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getEnumLiteralReferenceRuleAccess().getLiteralEnumLiteralCrossReference_0());
              			
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
    // $ANTLR end "ruleEnumLiteralReferenceRule"


    // $ANTLR start "entryRuleLiteralRule"
    // InternalDataDescriptionLanguage.g:1284:1: entryRuleLiteralRule returns [EObject current=null] : iv_ruleLiteralRule= ruleLiteralRule EOF ;
    public final EObject entryRuleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1284:52: (iv_ruleLiteralRule= ruleLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:1285:2: iv_ruleLiteralRule= ruleLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:1291:1: ruleLiteralRule returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule | this_EnumLiteralReferenceRule_4= ruleEnumLiteralReferenceRule ) ;
    public final EObject ruleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_StringLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;

        EObject this_InstanceLiteralRule_3 = null;

        EObject this_EnumLiteralReferenceRule_4 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1297:2: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule | this_EnumLiteralReferenceRule_4= ruleEnumLiteralReferenceRule ) )
            // InternalDataDescriptionLanguage.g:1298:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule | this_EnumLiteralReferenceRule_4= ruleEnumLiteralReferenceRule )
            {
            // InternalDataDescriptionLanguage.g:1298:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule | this_EnumLiteralReferenceRule_4= ruleEnumLiteralReferenceRule )
            int alt28=5;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1299:3: this_NumberLiteralRule_0= ruleNumberLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1311:3: this_StringLiteralRule_1= ruleStringLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1323:3: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1335:3: this_InstanceLiteralRule_3= ruleInstanceLiteralRule
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
                case 5 :
                    // InternalDataDescriptionLanguage.g:1347:3: this_EnumLiteralReferenceRule_4= ruleEnumLiteralReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralRuleAccess().getEnumLiteralReferenceRuleParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EnumLiteralReferenceRule_4=ruleEnumLiteralReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EnumLiteralReferenceRule_4;
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


    // $ANTLR start "entryRuleExpressionRule"
    // InternalDataDescriptionLanguage.g:1362:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1362:55: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1363:2: iv_ruleExpressionRule= ruleExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1369:1: ruleExpressionRule returns [EObject current=null] : this_OrExpressionRule_0= ruleOrExpressionRule ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1375:2: (this_OrExpressionRule_0= ruleOrExpressionRule )
            // InternalDataDescriptionLanguage.g:1376:2: this_OrExpressionRule_0= ruleOrExpressionRule
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
    // InternalDataDescriptionLanguage.g:1390:1: entryRuleOrExpressionRule returns [EObject current=null] : iv_ruleOrExpressionRule= ruleOrExpressionRule EOF ;
    public final EObject entryRuleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1390:57: (iv_ruleOrExpressionRule= ruleOrExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1391:2: iv_ruleOrExpressionRule= ruleOrExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1397:1: ruleOrExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) ;
    public final EObject ruleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1403:2: ( ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) )
            // InternalDataDescriptionLanguage.g:1404:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            {
            // InternalDataDescriptionLanguage.g:1404:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            // InternalDataDescriptionLanguage.g:1405:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            {
            // InternalDataDescriptionLanguage.g:1405:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1406:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1406:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            // InternalDataDescriptionLanguage.g:1407:5: lv_subExpressions_0_0= ruleXorExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_28);
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

            // InternalDataDescriptionLanguage.g:1424:3: (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==33) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1425:4: otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FOLLOW_29); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0());
            	      			
            	    }
            	    // InternalDataDescriptionLanguage.g:1429:4: ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    // InternalDataDescriptionLanguage.g:1430:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1430:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    // InternalDataDescriptionLanguage.g:1431:6: lv_subExpressions_2_0= ruleXorExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_28);
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
            	    break loop29;
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
    // InternalDataDescriptionLanguage.g:1453:1: entryRuleXorExpressionRule returns [EObject current=null] : iv_ruleXorExpressionRule= ruleXorExpressionRule EOF ;
    public final EObject entryRuleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1453:58: (iv_ruleXorExpressionRule= ruleXorExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1454:2: iv_ruleXorExpressionRule= ruleXorExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1460:1: ruleXorExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) ;
    public final EObject ruleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1466:2: ( ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) )
            // InternalDataDescriptionLanguage.g:1467:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            {
            // InternalDataDescriptionLanguage.g:1467:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            // InternalDataDescriptionLanguage.g:1468:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            {
            // InternalDataDescriptionLanguage.g:1468:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1469:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1469:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            // InternalDataDescriptionLanguage.g:1470:5: lv_subExpressions_0_0= ruleAndExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_30);
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

            // InternalDataDescriptionLanguage.g:1487:3: (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==34) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1488:4: otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,34,FOLLOW_29); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0());
            	      			
            	    }
            	    // InternalDataDescriptionLanguage.g:1492:4: ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    // InternalDataDescriptionLanguage.g:1493:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1493:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    // InternalDataDescriptionLanguage.g:1494:6: lv_subExpressions_2_0= ruleAndExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_30);
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
            	    break loop30;
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
    // InternalDataDescriptionLanguage.g:1516:1: entryRuleAndExpressionRule returns [EObject current=null] : iv_ruleAndExpressionRule= ruleAndExpressionRule EOF ;
    public final EObject entryRuleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1516:58: (iv_ruleAndExpressionRule= ruleAndExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1517:2: iv_ruleAndExpressionRule= ruleAndExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1523:1: ruleAndExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) ;
    public final EObject ruleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1529:2: ( ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) )
            // InternalDataDescriptionLanguage.g:1530:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            {
            // InternalDataDescriptionLanguage.g:1530:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            // InternalDataDescriptionLanguage.g:1531:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            {
            // InternalDataDescriptionLanguage.g:1531:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1532:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1532:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            // InternalDataDescriptionLanguage.g:1533:5: lv_subExpressions_0_0= ruleNotExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_31);
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

            // InternalDataDescriptionLanguage.g:1550:3: (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==35) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1551:4: otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,35,FOLLOW_29); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0());
            	      			
            	    }
            	    // InternalDataDescriptionLanguage.g:1555:4: ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    // InternalDataDescriptionLanguage.g:1556:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1556:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    // InternalDataDescriptionLanguage.g:1557:6: lv_subExpressions_2_0= ruleNotExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_31);
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
            	    break loop31;
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
    // InternalDataDescriptionLanguage.g:1579:1: entryRuleNotExpressionRule returns [EObject current=null] : iv_ruleNotExpressionRule= ruleNotExpressionRule EOF ;
    public final EObject entryRuleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1579:58: (iv_ruleNotExpressionRule= ruleNotExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1580:2: iv_ruleNotExpressionRule= ruleNotExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1586:1: ruleNotExpressionRule returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) ;
    public final EObject ruleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1592:2: ( ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) )
            // InternalDataDescriptionLanguage.g:1593:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            {
            // InternalDataDescriptionLanguage.g:1593:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            // InternalDataDescriptionLanguage.g:1594:3: ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            {
            // InternalDataDescriptionLanguage.g:1594:3: ( (lv_negated_0_0= '!' ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==36) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1595:4: (lv_negated_0_0= '!' )
                    {
                    // InternalDataDescriptionLanguage.g:1595:4: (lv_negated_0_0= '!' )
                    // InternalDataDescriptionLanguage.g:1596:5: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,36,FOLLOW_29); if (state.failed) return current;
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

            // InternalDataDescriptionLanguage.g:1608:3: ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1609:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1609:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            // InternalDataDescriptionLanguage.g:1610:5: lv_operand_1_0= ruleComparisonExpressionRule
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
    // InternalDataDescriptionLanguage.g:1631:1: entryRuleComparisonExpressionRule returns [EObject current=null] : iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF ;
    public final EObject entryRuleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1631:65: (iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1632:2: iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1638:1: ruleComparisonExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) ;
    public final EObject ruleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        EObject lv_comparison_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1644:2: ( ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) )
            // InternalDataDescriptionLanguage.g:1645:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            {
            // InternalDataDescriptionLanguage.g:1645:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            // InternalDataDescriptionLanguage.g:1646:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            {
            // InternalDataDescriptionLanguage.g:1646:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1647:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1647:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:1648:5: lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_32);
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

            // InternalDataDescriptionLanguage.g:1665:3: ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=60 && LA33_0<=65)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1666:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1666:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    // InternalDataDescriptionLanguage.g:1667:5: lv_comparison_1_0= rulePartialComparisonExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_32);
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
            	    break loop33;
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
    // InternalDataDescriptionLanguage.g:1688:1: entryRulePartialComparisonExpressionRule returns [EObject current=null] : iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF ;
    public final EObject entryRulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialComparisonExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1688:72: (iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1689:2: iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1695:1: rulePartialComparisonExpressionRule returns [EObject current=null] : ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) ;
    public final EObject rulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1701:2: ( ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) )
            // InternalDataDescriptionLanguage.g:1702:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            {
            // InternalDataDescriptionLanguage.g:1702:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            // InternalDataDescriptionLanguage.g:1703:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            {
            // InternalDataDescriptionLanguage.g:1703:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) )
            // InternalDataDescriptionLanguage.g:1704:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:1704:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            // InternalDataDescriptionLanguage.g:1705:5: lv_operator_0_0= ruleComparisonOperatorRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_29);
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

            // InternalDataDescriptionLanguage.g:1722:3: ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1723:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1723:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:1724:5: lv_subExpression_1_0= ruleAddOrSubtractExpressionRule
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
    // InternalDataDescriptionLanguage.g:1745:1: entryRuleAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOrSubtractExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1745:68: (iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1746:2: iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1752:1: ruleAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) ;
    public final EObject ruleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1758:2: ( ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) )
            // InternalDataDescriptionLanguage.g:1759:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            {
            // InternalDataDescriptionLanguage.g:1759:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            // InternalDataDescriptionLanguage.g:1760:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            {
            // InternalDataDescriptionLanguage.g:1760:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1761:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1761:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            // InternalDataDescriptionLanguage.g:1762:5: lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_33);
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

            // InternalDataDescriptionLanguage.g:1779:3: ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=66 && LA34_0<=67)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1780:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    {
            	    // InternalDataDescriptionLanguage.g:1780:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) )
            	    // InternalDataDescriptionLanguage.g:1781:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1781:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    // InternalDataDescriptionLanguage.g:1782:6: lv_operators_1_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_29);
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

            	    // InternalDataDescriptionLanguage.g:1799:4: ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    // InternalDataDescriptionLanguage.g:1800:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1800:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    // InternalDataDescriptionLanguage.g:1801:6: lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_33);
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
            	    break loop34;
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
    // InternalDataDescriptionLanguage.g:1823:1: entryRuleMultiplyDivideModuloExpressionRule returns [EObject current=null] : iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF ;
    public final EObject entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideModuloExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1823:75: (iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1824:2: iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1830:1: ruleMultiplyDivideModuloExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) ;
    public final EObject ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1836:2: ( ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) )
            // InternalDataDescriptionLanguage.g:1837:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            {
            // InternalDataDescriptionLanguage.g:1837:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            // InternalDataDescriptionLanguage.g:1838:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            {
            // InternalDataDescriptionLanguage.g:1838:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1839:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1839:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            // InternalDataDescriptionLanguage.g:1840:5: lv_leftOperand_0_0= rulePowerOfExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_34);
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

            // InternalDataDescriptionLanguage.g:1857:3: ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=68 && LA35_0<=70)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1858:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    {
            	    // InternalDataDescriptionLanguage.g:1858:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) )
            	    // InternalDataDescriptionLanguage.g:1859:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1859:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    // InternalDataDescriptionLanguage.g:1860:6: lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_29);
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

            	    // InternalDataDescriptionLanguage.g:1877:4: ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    // InternalDataDescriptionLanguage.g:1878:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1878:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    // InternalDataDescriptionLanguage.g:1879:6: lv_operands_2_0= rulePowerOfExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_34);
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
            	    break loop35;
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
    // InternalDataDescriptionLanguage.g:1901:1: entryRulePowerOfExpressionRule returns [EObject current=null] : iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF ;
    public final EObject entryRulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerOfExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1901:62: (iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1902:2: iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1908:1: rulePowerOfExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) ;
    public final EObject rulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_leftOperand_0_0 = null;

        EObject lv_rightOperand_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1914:2: ( ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) )
            // InternalDataDescriptionLanguage.g:1915:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            {
            // InternalDataDescriptionLanguage.g:1915:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            // InternalDataDescriptionLanguage.g:1916:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            {
            // InternalDataDescriptionLanguage.g:1916:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1917:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1917:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:1918:5: lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_35);
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

            // InternalDataDescriptionLanguage.g:1935:3: (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==37) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1936:4: otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    {
                    otherlv_1=(Token)match(input,37,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:1940:4: ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    // InternalDataDescriptionLanguage.g:1941:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    {
                    // InternalDataDescriptionLanguage.g:1941:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    // InternalDataDescriptionLanguage.g:1942:6: lv_rightOperand_2_0= rulePowerOfExpressionRule
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
    // InternalDataDescriptionLanguage.g:1964:1: entryRuleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryAddOrSubtractExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1964:73: (iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1965:2: iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1971:1: ruleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) ) ) ;
    public final EObject ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operators_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1977:2: ( ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) ) ) )
            // InternalDataDescriptionLanguage.g:1978:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) ) )
            {
            // InternalDataDescriptionLanguage.g:1978:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) ) )
            // InternalDataDescriptionLanguage.g:1979:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleValueRule ) )
            {
            // InternalDataDescriptionLanguage.g:1979:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=66 && LA37_0<=67)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1980:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1980:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    // InternalDataDescriptionLanguage.g:1981:5: lv_operators_0_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_29);
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
            	    break loop37;
                }
            } while (true);

            // InternalDataDescriptionLanguage.g:1998:3: ( (lv_subExpression_1_0= ruleValueRule ) )
            // InternalDataDescriptionLanguage.g:1999:4: (lv_subExpression_1_0= ruleValueRule )
            {
            // InternalDataDescriptionLanguage.g:1999:4: (lv_subExpression_1_0= ruleValueRule )
            // InternalDataDescriptionLanguage.g:2000:5: lv_subExpression_1_0= ruleValueRule
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
    // InternalDataDescriptionLanguage.g:2021:1: entryRuleValueRule returns [EObject current=null] : iv_ruleValueRule= ruleValueRule EOF ;
    public final EObject entryRuleValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2021:50: (iv_ruleValueRule= ruleValueRule EOF )
            // InternalDataDescriptionLanguage.g:2022:2: iv_ruleValueRule= ruleValueRule EOF
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
    // InternalDataDescriptionLanguage.g:2028:1: ruleValueRule returns [EObject current=null] : (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule ) ;
    public final EObject ruleValueRule() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayRule_0 = null;

        EObject this_CallRule_1 = null;

        EObject this_LiteralRule_2 = null;

        EObject this_ParanthesesRule_3 = null;

        EObject this_ReferenceRule_4 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2034:2: ( (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule ) )
            // InternalDataDescriptionLanguage.g:2035:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )
            {
            // InternalDataDescriptionLanguage.g:2035:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )
            int alt38=5;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt38=1;
                }
                break;
            case RULE_QUOTED_ID:
                {
                int LA38_2 = input.LA(2);

                if ( (LA38_2==27||LA38_2==54) ) {
                    alt38=2;
                }
                else if ( (synpred45_InternalDataDescriptionLanguage()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA38_3 = input.LA(2);

                if ( (LA38_3==27||LA38_3==54) ) {
                    alt38=2;
                }
                else if ( (synpred45_InternalDataDescriptionLanguage()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case RULE_DOUBLE:
            case RULE_INT:
            case 41:
            case 42:
                {
                alt38=3;
                }
                break;
            case 27:
                {
                alt38=4;
                }
                break;
            case 19:
            case 32:
                {
                alt38=5;
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
                    // InternalDataDescriptionLanguage.g:2036:3: this_ArrayRule_0= ruleArrayRule
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
                    // InternalDataDescriptionLanguage.g:2048:3: this_CallRule_1= ruleCallRule
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
                    // InternalDataDescriptionLanguage.g:2060:3: this_LiteralRule_2= ruleLiteralRule
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
                    // InternalDataDescriptionLanguage.g:2072:3: this_ParanthesesRule_3= ruleParanthesesRule
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
                    // InternalDataDescriptionLanguage.g:2084:3: this_ReferenceRule_4= ruleReferenceRule
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
    // InternalDataDescriptionLanguage.g:2099:1: entryRuleArrayRule returns [EObject current=null] : iv_ruleArrayRule= ruleArrayRule EOF ;
    public final EObject entryRuleArrayRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2099:50: (iv_ruleArrayRule= ruleArrayRule EOF )
            // InternalDataDescriptionLanguage.g:2100:2: iv_ruleArrayRule= ruleArrayRule EOF
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
    // InternalDataDescriptionLanguage.g:2106:1: ruleArrayRule returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2112:2: ( ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' ) )
            // InternalDataDescriptionLanguage.g:2113:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            {
            // InternalDataDescriptionLanguage.g:2113:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']' )
            // InternalDataDescriptionLanguage.g:2114:3: () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )? otherlv_5= ']'
            {
            // InternalDataDescriptionLanguage.g:2114:3: ()
            // InternalDataDescriptionLanguage.g:2115:4: 
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

            otherlv_1=(Token)match(input,38,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalDataDescriptionLanguage.g:2128:3: ( ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_STRING && LA40_0<=RULE_ID)||LA40_0==19||LA40_0==27||LA40_0==32||LA40_0==38||(LA40_0>=41 && LA40_0<=42)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2129:4: ( (lv_values_2_0= ruleValueRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    {
                    // InternalDataDescriptionLanguage.g:2129:4: ( (lv_values_2_0= ruleValueRule ) )
                    // InternalDataDescriptionLanguage.g:2130:5: (lv_values_2_0= ruleValueRule )
                    {
                    // InternalDataDescriptionLanguage.g:2130:5: (lv_values_2_0= ruleValueRule )
                    // InternalDataDescriptionLanguage.g:2131:6: lv_values_2_0= ruleValueRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_37);
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

                    // InternalDataDescriptionLanguage.g:2148:4: (otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==28) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:2149:5: otherlv_3= ',' ( (lv_values_4_0= ruleValueRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,28,FOLLOW_29); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalDataDescriptionLanguage.g:2153:5: ( (lv_values_4_0= ruleValueRule ) )
                    	    // InternalDataDescriptionLanguage.g:2154:6: (lv_values_4_0= ruleValueRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:2154:6: (lv_values_4_0= ruleValueRule )
                    	    // InternalDataDescriptionLanguage.g:2155:7: lv_values_4_0= ruleValueRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesValueRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_37);
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
                    	    break loop39;
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
    // InternalDataDescriptionLanguage.g:2182:1: entryRuleParanthesesRule returns [EObject current=null] : iv_ruleParanthesesRule= ruleParanthesesRule EOF ;
    public final EObject entryRuleParanthesesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesesRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2182:56: (iv_ruleParanthesesRule= ruleParanthesesRule EOF )
            // InternalDataDescriptionLanguage.g:2183:2: iv_ruleParanthesesRule= ruleParanthesesRule EOF
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
    // InternalDataDescriptionLanguage.g:2189:1: ruleParanthesesRule returns [EObject current=null] : (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) ;
    public final EObject ruleParanthesesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2195:2: ( (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) )
            // InternalDataDescriptionLanguage.g:2196:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            {
            // InternalDataDescriptionLanguage.g:2196:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            // InternalDataDescriptionLanguage.g:2197:3: otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalDataDescriptionLanguage.g:2201:3: ( (lv_subExpression_1_0= ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:2202:4: (lv_subExpression_1_0= ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:2202:4: (lv_subExpression_1_0= ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:2203:5: lv_subExpression_1_0= ruleExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_38);
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

            otherlv_2=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2228:1: entryRuleCallRule returns [EObject current=null] : iv_ruleCallRule= ruleCallRule EOF ;
    public final EObject entryRuleCallRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2228:49: (iv_ruleCallRule= ruleCallRule EOF )
            // InternalDataDescriptionLanguage.g:2229:2: iv_ruleCallRule= ruleCallRule EOF
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
    // InternalDataDescriptionLanguage.g:2235:1: ruleCallRule returns [EObject current=null] : ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) ;
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
            // InternalDataDescriptionLanguage.g:2241:2: ( ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) )
            // InternalDataDescriptionLanguage.g:2242:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            {
            // InternalDataDescriptionLanguage.g:2242:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            // InternalDataDescriptionLanguage.g:2243:3: ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')'
            {
            // InternalDataDescriptionLanguage.g:2243:3: ( (lv_function_0_0= ruleFunctionNameRule ) )
            // InternalDataDescriptionLanguage.g:2244:4: (lv_function_0_0= ruleFunctionNameRule )
            {
            // InternalDataDescriptionLanguage.g:2244:4: (lv_function_0_0= ruleFunctionNameRule )
            // InternalDataDescriptionLanguage.g:2245:5: lv_function_0_0= ruleFunctionNameRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCallRuleAccess().getFunctionFunctionNameRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_19);
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

            otherlv_1=(Token)match(input,27,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalDataDescriptionLanguage.g:2266:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=RULE_STRING && LA42_0<=RULE_ID)||LA42_0==19||LA42_0==27||LA42_0==32||LA42_0==36||LA42_0==38||(LA42_0>=41 && LA42_0<=42)||(LA42_0>=66 && LA42_0<=67)) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2267:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalDataDescriptionLanguage.g:2267:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalDataDescriptionLanguage.g:2268:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalDataDescriptionLanguage.g:2268:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalDataDescriptionLanguage.g:2269:6: lv_parameters_2_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_20);
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

                    // InternalDataDescriptionLanguage.g:2286:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==28) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:2287:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,28,FOLLOW_29); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalDataDescriptionLanguage.g:2291:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalDataDescriptionLanguage.g:2292:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:2292:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalDataDescriptionLanguage.g:2293:7: lv_parameters_4_0= ruleExpressionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_20);
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
                    	    break loop41;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2320:1: entryRuleConstantReferenceRule returns [EObject current=null] : iv_ruleConstantReferenceRule= ruleConstantReferenceRule EOF ;
    public final EObject entryRuleConstantReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantReferenceRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2320:62: (iv_ruleConstantReferenceRule= ruleConstantReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:2321:2: iv_ruleConstantReferenceRule= ruleConstantReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:2327:1: ruleConstantReferenceRule returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleConstantReferenceRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2333:2: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDescriptionLanguage.g:2334:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDescriptionLanguage.g:2334:2: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:2335:3: ( ruleQualifiedName )
            {
            // InternalDataDescriptionLanguage.g:2335:3: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:2336:4: ruleQualifiedName
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


    // $ANTLR start "entryRuleInstanceLiteralRule"
    // InternalDataDescriptionLanguage.g:2356:1: entryRuleInstanceLiteralRule returns [EObject current=null] : iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF ;
    public final EObject entryRuleInstanceLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2356:60: (iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:2357:2: iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:2363:1: ruleInstanceLiteralRule returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' ) ;
    public final EObject ruleInstanceLiteralRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2369:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' ) )
            // InternalDataDescriptionLanguage.g:2370:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )
            {
            // InternalDataDescriptionLanguage.g:2370:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )
            // InternalDataDescriptionLanguage.g:2371:3: ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}'
            {
            // InternalDataDescriptionLanguage.g:2371:3: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:2372:4: ( ruleQualifiedName )
            {
            // InternalDataDescriptionLanguage.g:2372:4: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:2373:5: ruleQualifiedName
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

            otherlv_1=(Token)match(input,16,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInstanceLiteralRuleAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalDataDescriptionLanguage.g:2394:3: ( (lv_attributes_2_0= ruleAttributeRule ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=RULE_QUOTED_ID && LA43_0<=RULE_ID)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2395:4: (lv_attributes_2_0= ruleAttributeRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:2395:4: (lv_attributes_2_0= ruleAttributeRule )
            	    // InternalDataDescriptionLanguage.g:2396:5: lv_attributes_2_0= ruleAttributeRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getInstanceLiteralRuleAccess().getAttributesAttributeRuleParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_40);
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
            	    break loop43;
                }
            } while (true);

            otherlv_3=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2421:1: entryRuleAttributeRule returns [EObject current=null] : iv_ruleAttributeRule= ruleAttributeRule EOF ;
    public final EObject entryRuleAttributeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2421:54: (iv_ruleAttributeRule= ruleAttributeRule EOF )
            // InternalDataDescriptionLanguage.g:2422:2: iv_ruleAttributeRule= ruleAttributeRule EOF
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
    // InternalDataDescriptionLanguage.g:2428:1: ruleAttributeRule returns [EObject current=null] : ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' ) ;
    public final EObject ruleAttributeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2434:2: ( ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' ) )
            // InternalDataDescriptionLanguage.g:2435:2: ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' )
            {
            // InternalDataDescriptionLanguage.g:2435:2: ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' )
            // InternalDataDescriptionLanguage.g:2436:3: ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';'
            {
            // InternalDataDescriptionLanguage.g:2436:3: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:2437:4: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:2437:4: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:2438:5: ruleStringOrId
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
            pushFollow(FOLLOW_41);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,40,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1());
              		
            }
            // InternalDataDescriptionLanguage.g:2459:3: ( (lv_value_2_0= ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:2460:4: (lv_value_2_0= ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:2460:4: (lv_value_2_0= ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:2461:5: lv_value_2_0= ruleExpressionRule
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
    // InternalDataDescriptionLanguage.g:2486:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2486:58: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:2487:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:2493:1: ruleNumberLiteralRule returns [EObject current=null] : (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_RealLiteralRule_0 = null;

        EObject this_IntegerLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2499:2: ( (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) )
            // InternalDataDescriptionLanguage.g:2500:2: (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            {
            // InternalDataDescriptionLanguage.g:2500:2: (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_DOUBLE) ) {
                alt44=1;
            }
            else if ( (LA44_0==RULE_INT) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2501:3: this_RealLiteralRule_0= ruleRealLiteralRule
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
                    // InternalDataDescriptionLanguage.g:2513:3: this_IntegerLiteralRule_1= ruleIntegerLiteralRule
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
    // InternalDataDescriptionLanguage.g:2528:1: entryRuleRealLiteralRule returns [EObject current=null] : iv_ruleRealLiteralRule= ruleRealLiteralRule EOF ;
    public final EObject entryRuleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2528:56: (iv_ruleRealLiteralRule= ruleRealLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:2529:2: iv_ruleRealLiteralRule= ruleRealLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:2535:1: ruleRealLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2541:2: ( ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalDataDescriptionLanguage.g:2542:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalDataDescriptionLanguage.g:2542:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalDataDescriptionLanguage.g:2543:3: ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalDataDescriptionLanguage.g:2543:3: ( (lv_literal_0_0= RULE_DOUBLE ) )
            // InternalDataDescriptionLanguage.g:2544:4: (lv_literal_0_0= RULE_DOUBLE )
            {
            // InternalDataDescriptionLanguage.g:2544:4: (lv_literal_0_0= RULE_DOUBLE )
            // InternalDataDescriptionLanguage.g:2545:5: lv_literal_0_0= RULE_DOUBLE
            {
            lv_literal_0_0=(Token)match(input,RULE_DOUBLE,FOLLOW_42); if (state.failed) return current;
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

            // InternalDataDescriptionLanguage.g:2561:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=71 && LA45_0<=90)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2562:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalDataDescriptionLanguage.g:2562:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalDataDescriptionLanguage.g:2563:5: lv_factor_1_0= ruleFactorRule
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
    // InternalDataDescriptionLanguage.g:2584:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2584:59: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:2585:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:2591:1: ruleIntegerLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2597:2: ( ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalDataDescriptionLanguage.g:2598:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalDataDescriptionLanguage.g:2598:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalDataDescriptionLanguage.g:2599:3: ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalDataDescriptionLanguage.g:2599:3: ( (lv_literal_0_0= RULE_INT ) )
            // InternalDataDescriptionLanguage.g:2600:4: (lv_literal_0_0= RULE_INT )
            {
            // InternalDataDescriptionLanguage.g:2600:4: (lv_literal_0_0= RULE_INT )
            // InternalDataDescriptionLanguage.g:2601:5: lv_literal_0_0= RULE_INT
            {
            lv_literal_0_0=(Token)match(input,RULE_INT,FOLLOW_42); if (state.failed) return current;
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

            // InternalDataDescriptionLanguage.g:2617:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=71 && LA46_0<=90)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2618:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalDataDescriptionLanguage.g:2618:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalDataDescriptionLanguage.g:2619:5: lv_factor_1_0= ruleFactorRule
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
    // InternalDataDescriptionLanguage.g:2640:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2640:58: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:2641:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:2647:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2653:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalDataDescriptionLanguage.g:2654:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalDataDescriptionLanguage.g:2654:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:2655:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:2655:3: (lv_value_0_0= RULE_STRING )
            // InternalDataDescriptionLanguage.g:2656:4: lv_value_0_0= RULE_STRING
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
    // InternalDataDescriptionLanguage.g:2675:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2675:59: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:2676:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:2682:1: ruleBooleanLiteralRule returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2688:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalDataDescriptionLanguage.g:2689:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalDataDescriptionLanguage.g:2689:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalDataDescriptionLanguage.g:2690:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalDataDescriptionLanguage.g:2690:3: ()
            // InternalDataDescriptionLanguage.g:2691:4: 
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

            // InternalDataDescriptionLanguage.g:2700:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==41) ) {
                alt47=1;
            }
            else if ( (LA47_0==42) ) {
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
                    // InternalDataDescriptionLanguage.g:2701:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalDataDescriptionLanguage.g:2701:4: ( (lv_value_1_0= 'true' ) )
                    // InternalDataDescriptionLanguage.g:2702:5: (lv_value_1_0= 'true' )
                    {
                    // InternalDataDescriptionLanguage.g:2702:5: (lv_value_1_0= 'true' )
                    // InternalDataDescriptionLanguage.g:2703:6: lv_value_1_0= 'true'
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
                    // InternalDataDescriptionLanguage.g:2716:4: otherlv_2= 'false'
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


    // $ANTLR start "entryRuleConstraintRule"
    // InternalDataDescriptionLanguage.g:2725:1: entryRuleConstraintRule returns [EObject current=null] : iv_ruleConstraintRule= ruleConstraintRule EOF ;
    public final EObject entryRuleConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2725:55: (iv_ruleConstraintRule= ruleConstraintRule EOF )
            // InternalDataDescriptionLanguage.g:2726:2: iv_ruleConstraintRule= ruleConstraintRule EOF
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
    // InternalDataDescriptionLanguage.g:2732:1: ruleConstraintRule returns [EObject current=null] : (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule ) ;
    public final EObject ruleConstraintRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_InstanceLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2738:2: ( (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule ) )
            // InternalDataDescriptionLanguage.g:2739:2: (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule )
            {
            // InternalDataDescriptionLanguage.g:2739:2: (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule )
            // InternalDataDescriptionLanguage.g:2740:3: otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule
            {
            otherlv_0=(Token)match(input,43,FOLLOW_4); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2759:1: entryRuleAttributeDefinitionRule returns [EObject current=null] : iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF ;
    public final EObject entryRuleAttributeDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeDefinitionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2759:64: (iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF )
            // InternalDataDescriptionLanguage.g:2760:2: iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF
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
    // InternalDataDescriptionLanguage.g:2766:1: ruleAttributeDefinitionRule returns [EObject current=null] : ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeRule ) ) (otherlv_4= ':=' ( (lv_initialisation_5_0= ruleExpressionRule ) ) )? otherlv_6= ';' ) ;
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
            // InternalDataDescriptionLanguage.g:2772:2: ( ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeRule ) ) (otherlv_4= ':=' ( (lv_initialisation_5_0= ruleExpressionRule ) ) )? otherlv_6= ';' ) )
            // InternalDataDescriptionLanguage.g:2773:2: ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeRule ) ) (otherlv_4= ':=' ( (lv_initialisation_5_0= ruleExpressionRule ) ) )? otherlv_6= ';' )
            {
            // InternalDataDescriptionLanguage.g:2773:2: ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeRule ) ) (otherlv_4= ':=' ( (lv_initialisation_5_0= ruleExpressionRule ) ) )? otherlv_6= ';' )
            // InternalDataDescriptionLanguage.g:2774:3: ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeRule ) ) (otherlv_4= ':=' ( (lv_initialisation_5_0= ruleExpressionRule ) ) )? otherlv_6= ';'
            {
            // InternalDataDescriptionLanguage.g:2774:3: ( (lv_constraints_0_0= ruleConstraintRule ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==43) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:2775:4: (lv_constraints_0_0= ruleConstraintRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:2775:4: (lv_constraints_0_0= ruleConstraintRule )
            	    // InternalDataDescriptionLanguage.g:2776:5: lv_constraints_0_0= ruleConstraintRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_43);
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
            	    break loop48;
                }
            } while (true);

            // InternalDataDescriptionLanguage.g:2793:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:2794:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:2794:4: (lv_name_1_0= ruleStringOrId )
            // InternalDataDescriptionLanguage.g:2795:5: lv_name_1_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_7);
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

            otherlv_2=(Token)match(input,18,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_2());
              		
            }
            // InternalDataDescriptionLanguage.g:2816:3: ( (lv_type_3_0= ruleTypeRule ) )
            // InternalDataDescriptionLanguage.g:2817:4: (lv_type_3_0= ruleTypeRule )
            {
            // InternalDataDescriptionLanguage.g:2817:4: (lv_type_3_0= ruleTypeRule )
            // InternalDataDescriptionLanguage.g:2818:5: lv_type_3_0= ruleTypeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_45);
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

            // InternalDataDescriptionLanguage.g:2835:3: (otherlv_4= ':=' ( (lv_initialisation_5_0= ruleExpressionRule ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==40) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2836:4: otherlv_4= ':=' ( (lv_initialisation_5_0= ruleExpressionRule ) )
                    {
                    otherlv_4=(Token)match(input,40,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_4_0());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:2840:4: ( (lv_initialisation_5_0= ruleExpressionRule ) )
                    // InternalDataDescriptionLanguage.g:2841:5: (lv_initialisation_5_0= ruleExpressionRule )
                    {
                    // InternalDataDescriptionLanguage.g:2841:5: (lv_initialisation_5_0= ruleExpressionRule )
                    // InternalDataDescriptionLanguage.g:2842:6: lv_initialisation_5_0= ruleExpressionRule
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

            otherlv_6=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2868:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
    public final EObject entryRuleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:2868:49: (iv_ruleTypeRule= ruleTypeRule EOF )
            // InternalDataDescriptionLanguage.g:2869:2: iv_ruleTypeRule= ruleTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:2875:1: ruleTypeRule returns [EObject current=null] : (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule ) ;
    public final EObject ruleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject this_StringTypeRule_0 = null;

        EObject this_IntTypeRule_1 = null;

        EObject this_RealTypeRule_2 = null;

        EObject this_BooleanTypeRule_3 = null;

        EObject this_LiteralTypeRule_4 = null;

        EObject this_ArrayTypeRule_5 = null;

        EObject this_InstanceTypeRule_6 = null;

        EObject this_VoidTypeRule_7 = null;

        EObject this_ExpressionTypeRule_8 = null;

        EObject this_DataTypeRule_9 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2881:2: ( (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule ) )
            // InternalDataDescriptionLanguage.g:2882:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule )
            {
            // InternalDataDescriptionLanguage.g:2882:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_LiteralTypeRule_4= ruleLiteralTypeRule | this_ArrayTypeRule_5= ruleArrayTypeRule | this_InstanceTypeRule_6= ruleInstanceTypeRule | this_VoidTypeRule_7= ruleVoidTypeRule | this_ExpressionTypeRule_8= ruleExpressionTypeRule | this_DataTypeRule_9= ruleDataTypeRule )
            int alt50=10;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt50=1;
                }
                break;
            case 47:
                {
                alt50=2;
                }
                break;
            case 48:
                {
                alt50=3;
                }
                break;
            case 49:
                {
                alt50=4;
                }
                break;
            case 44:
                {
                alt50=5;
                }
                break;
            case 51:
                {
                alt50=6;
                }
                break;
            case 31:
                {
                alt50=7;
                }
                break;
            case 50:
                {
                alt50=8;
                }
                break;
            case 46:
                {
                alt50=9;
                }
                break;
            case 19:
                {
                alt50=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2883:3: this_StringTypeRule_0= ruleStringTypeRule
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
                    // InternalDataDescriptionLanguage.g:2895:3: this_IntTypeRule_1= ruleIntTypeRule
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
                    // InternalDataDescriptionLanguage.g:2907:3: this_RealTypeRule_2= ruleRealTypeRule
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
                    // InternalDataDescriptionLanguage.g:2919:3: this_BooleanTypeRule_3= ruleBooleanTypeRule
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
                    // InternalDataDescriptionLanguage.g:2931:3: this_LiteralTypeRule_4= ruleLiteralTypeRule
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
                    // InternalDataDescriptionLanguage.g:2943:3: this_ArrayTypeRule_5= ruleArrayTypeRule
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
                    // InternalDataDescriptionLanguage.g:2955:3: this_InstanceTypeRule_6= ruleInstanceTypeRule
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
                    // InternalDataDescriptionLanguage.g:2967:3: this_VoidTypeRule_7= ruleVoidTypeRule
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
                    // InternalDataDescriptionLanguage.g:2979:3: this_ExpressionTypeRule_8= ruleExpressionTypeRule
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
                    // InternalDataDescriptionLanguage.g:2991:3: this_DataTypeRule_9= ruleDataTypeRule
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
    // InternalDataDescriptionLanguage.g:3006:1: entryRuleLiteralTypeRule returns [EObject current=null] : iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF ;
    public final EObject entryRuleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:3006:56: (iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF )
            // InternalDataDescriptionLanguage.g:3007:2: iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:3013:1: ruleLiteralTypeRule returns [EObject current=null] : ( () otherlv_1= 'literal' ) ;
    public final EObject ruleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3019:2: ( ( () otherlv_1= 'literal' ) )
            // InternalDataDescriptionLanguage.g:3020:2: ( () otherlv_1= 'literal' )
            {
            // InternalDataDescriptionLanguage.g:3020:2: ( () otherlv_1= 'literal' )
            // InternalDataDescriptionLanguage.g:3021:3: () otherlv_1= 'literal'
            {
            // InternalDataDescriptionLanguage.g:3021:3: ()
            // InternalDataDescriptionLanguage.g:3022:4: 
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

            otherlv_1=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:3039:1: entryRuleInstanceTypeRule returns [EObject current=null] : iv_ruleInstanceTypeRule= ruleInstanceTypeRule EOF ;
    public final EObject entryRuleInstanceTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:3039:57: (iv_ruleInstanceTypeRule= ruleInstanceTypeRule EOF )
            // InternalDataDescriptionLanguage.g:3040:2: iv_ruleInstanceTypeRule= ruleInstanceTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:3046:1: ruleInstanceTypeRule returns [EObject current=null] : ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleInstanceTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3052:2: ( ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) ) )
            // InternalDataDescriptionLanguage.g:3053:2: ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) )
            {
            // InternalDataDescriptionLanguage.g:3053:2: ( () otherlv_1= 'instance' ( ( ruleQualifiedName ) ) )
            // InternalDataDescriptionLanguage.g:3054:3: () otherlv_1= 'instance' ( ( ruleQualifiedName ) )
            {
            // InternalDataDescriptionLanguage.g:3054:3: ()
            // InternalDataDescriptionLanguage.g:3055:4: 
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

            otherlv_1=(Token)match(input,31,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInstanceTypeRuleAccess().getInstanceKeyword_1());
              		
            }
            // InternalDataDescriptionLanguage.g:3068:3: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:3069:4: ( ruleQualifiedName )
            {
            // InternalDataDescriptionLanguage.g:3069:4: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:3070:5: ruleQualifiedName
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
    // InternalDataDescriptionLanguage.g:3091:1: entryRuleStringTypeRule returns [EObject current=null] : iv_ruleStringTypeRule= ruleStringTypeRule EOF ;
    public final EObject entryRuleStringTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:3091:55: (iv_ruleStringTypeRule= ruleStringTypeRule EOF )
            // InternalDataDescriptionLanguage.g:3092:2: iv_ruleStringTypeRule= ruleStringTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:3098:1: ruleStringTypeRule returns [EObject current=null] : ( () otherlv_1= 'string' ) ;
    public final EObject ruleStringTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3104:2: ( ( () otherlv_1= 'string' ) )
            // InternalDataDescriptionLanguage.g:3105:2: ( () otherlv_1= 'string' )
            {
            // InternalDataDescriptionLanguage.g:3105:2: ( () otherlv_1= 'string' )
            // InternalDataDescriptionLanguage.g:3106:3: () otherlv_1= 'string'
            {
            // InternalDataDescriptionLanguage.g:3106:3: ()
            // InternalDataDescriptionLanguage.g:3107:4: 
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
    // InternalDataDescriptionLanguage.g:3124:1: entryRuleExpressionTypeRule returns [EObject current=null] : iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF ;
    public final EObject entryRuleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:3124:59: (iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF )
            // InternalDataDescriptionLanguage.g:3125:2: iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:3131:1: ruleExpressionTypeRule returns [EObject current=null] : ( () otherlv_1= 'expression' ) ;
    public final EObject ruleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3137:2: ( ( () otherlv_1= 'expression' ) )
            // InternalDataDescriptionLanguage.g:3138:2: ( () otherlv_1= 'expression' )
            {
            // InternalDataDescriptionLanguage.g:3138:2: ( () otherlv_1= 'expression' )
            // InternalDataDescriptionLanguage.g:3139:3: () otherlv_1= 'expression'
            {
            // InternalDataDescriptionLanguage.g:3139:3: ()
            // InternalDataDescriptionLanguage.g:3140:4: 
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
    // InternalDataDescriptionLanguage.g:3157:1: entryRuleIntTypeRule returns [EObject current=null] : iv_ruleIntTypeRule= ruleIntTypeRule EOF ;
    public final EObject entryRuleIntTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:3157:52: (iv_ruleIntTypeRule= ruleIntTypeRule EOF )
            // InternalDataDescriptionLanguage.g:3158:2: iv_ruleIntTypeRule= ruleIntTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:3164:1: ruleIntTypeRule returns [EObject current=null] : ( () otherlv_1= 'int' ) ;
    public final EObject ruleIntTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3170:2: ( ( () otherlv_1= 'int' ) )
            // InternalDataDescriptionLanguage.g:3171:2: ( () otherlv_1= 'int' )
            {
            // InternalDataDescriptionLanguage.g:3171:2: ( () otherlv_1= 'int' )
            // InternalDataDescriptionLanguage.g:3172:3: () otherlv_1= 'int'
            {
            // InternalDataDescriptionLanguage.g:3172:3: ()
            // InternalDataDescriptionLanguage.g:3173:4: 
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


    // $ANTLR start "entryRuleRealTypeRule"
    // InternalDataDescriptionLanguage.g:3190:1: entryRuleRealTypeRule returns [EObject current=null] : iv_ruleRealTypeRule= ruleRealTypeRule EOF ;
    public final EObject entryRuleRealTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:3190:53: (iv_ruleRealTypeRule= ruleRealTypeRule EOF )
            // InternalDataDescriptionLanguage.g:3191:2: iv_ruleRealTypeRule= ruleRealTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:3197:1: ruleRealTypeRule returns [EObject current=null] : ( () otherlv_1= 'real' ) ;
    public final EObject ruleRealTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3203:2: ( ( () otherlv_1= 'real' ) )
            // InternalDataDescriptionLanguage.g:3204:2: ( () otherlv_1= 'real' )
            {
            // InternalDataDescriptionLanguage.g:3204:2: ( () otherlv_1= 'real' )
            // InternalDataDescriptionLanguage.g:3205:3: () otherlv_1= 'real'
            {
            // InternalDataDescriptionLanguage.g:3205:3: ()
            // InternalDataDescriptionLanguage.g:3206:4: 
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

            otherlv_1=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:3223:1: entryRuleBooleanTypeRule returns [EObject current=null] : iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF ;
    public final EObject entryRuleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:3223:56: (iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF )
            // InternalDataDescriptionLanguage.g:3224:2: iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:3230:1: ruleBooleanTypeRule returns [EObject current=null] : ( () otherlv_1= 'boolean' ) ;
    public final EObject ruleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3236:2: ( ( () otherlv_1= 'boolean' ) )
            // InternalDataDescriptionLanguage.g:3237:2: ( () otherlv_1= 'boolean' )
            {
            // InternalDataDescriptionLanguage.g:3237:2: ( () otherlv_1= 'boolean' )
            // InternalDataDescriptionLanguage.g:3238:3: () otherlv_1= 'boolean'
            {
            // InternalDataDescriptionLanguage.g:3238:3: ()
            // InternalDataDescriptionLanguage.g:3239:4: 
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
    // InternalDataDescriptionLanguage.g:3256:1: entryRuleVoidTypeRule returns [EObject current=null] : iv_ruleVoidTypeRule= ruleVoidTypeRule EOF ;
    public final EObject entryRuleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVoidTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:3256:53: (iv_ruleVoidTypeRule= ruleVoidTypeRule EOF )
            // InternalDataDescriptionLanguage.g:3257:2: iv_ruleVoidTypeRule= ruleVoidTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:3263:1: ruleVoidTypeRule returns [EObject current=null] : ( () otherlv_1= 'void' ) ;
    public final EObject ruleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3269:2: ( ( () otherlv_1= 'void' ) )
            // InternalDataDescriptionLanguage.g:3270:2: ( () otherlv_1= 'void' )
            {
            // InternalDataDescriptionLanguage.g:3270:2: ( () otherlv_1= 'void' )
            // InternalDataDescriptionLanguage.g:3271:3: () otherlv_1= 'void'
            {
            // InternalDataDescriptionLanguage.g:3271:3: ()
            // InternalDataDescriptionLanguage.g:3272:4: 
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
    // InternalDataDescriptionLanguage.g:3289:1: entryRuleDataTypeRule returns [EObject current=null] : iv_ruleDataTypeRule= ruleDataTypeRule EOF ;
    public final EObject entryRuleDataTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:3289:53: (iv_ruleDataTypeRule= ruleDataTypeRule EOF )
            // InternalDataDescriptionLanguage.g:3290:2: iv_ruleDataTypeRule= ruleDataTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:3296:1: ruleDataTypeRule returns [EObject current=null] : ( () otherlv_1= 'data' ) ;
    public final EObject ruleDataTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3302:2: ( ( () otherlv_1= 'data' ) )
            // InternalDataDescriptionLanguage.g:3303:2: ( () otherlv_1= 'data' )
            {
            // InternalDataDescriptionLanguage.g:3303:2: ( () otherlv_1= 'data' )
            // InternalDataDescriptionLanguage.g:3304:3: () otherlv_1= 'data'
            {
            // InternalDataDescriptionLanguage.g:3304:3: ()
            // InternalDataDescriptionLanguage.g:3305:4: 
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
    // InternalDataDescriptionLanguage.g:3322:1: entryRuleArrayTypeRule returns [EObject current=null] : iv_ruleArrayTypeRule= ruleArrayTypeRule EOF ;
    public final EObject entryRuleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:3322:54: (iv_ruleArrayTypeRule= ruleArrayTypeRule EOF )
            // InternalDataDescriptionLanguage.g:3323:2: iv_ruleArrayTypeRule= ruleArrayTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:3329:1: ruleArrayTypeRule returns [EObject current=null] : (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) ;
    public final EObject ruleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_elements_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3335:2: ( (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) )
            // InternalDataDescriptionLanguage.g:3336:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            {
            // InternalDataDescriptionLanguage.g:3336:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            // InternalDataDescriptionLanguage.g:3337:3: otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) )
            {
            otherlv_0=(Token)match(input,51,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0());
              		
            }
            // InternalDataDescriptionLanguage.g:3341:3: ( (lv_elements_1_0= ruleTypeRule ) )
            // InternalDataDescriptionLanguage.g:3342:4: (lv_elements_1_0= ruleTypeRule )
            {
            // InternalDataDescriptionLanguage.g:3342:4: (lv_elements_1_0= ruleTypeRule )
            // InternalDataDescriptionLanguage.g:3343:5: lv_elements_1_0= ruleTypeRule
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
    // InternalDataDescriptionLanguage.g:3364:1: entryRuleParameterRule returns [EObject current=null] : iv_ruleParameterRule= ruleParameterRule EOF ;
    public final EObject entryRuleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRule = null;


        try {
            // InternalDataDescriptionLanguage.g:3364:54: (iv_ruleParameterRule= ruleParameterRule EOF )
            // InternalDataDescriptionLanguage.g:3365:2: iv_ruleParameterRule= ruleParameterRule EOF
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
    // InternalDataDescriptionLanguage.g:3371:1: ruleParameterRule returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) ;
    public final EObject ruleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3377:2: ( ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) )
            // InternalDataDescriptionLanguage.g:3378:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            {
            // InternalDataDescriptionLanguage.g:3378:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            // InternalDataDescriptionLanguage.g:3379:3: ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) )
            {
            // InternalDataDescriptionLanguage.g:3379:3: ( (lv_type_0_0= ruleTypeRule ) )
            // InternalDataDescriptionLanguage.g:3380:4: (lv_type_0_0= ruleTypeRule )
            {
            // InternalDataDescriptionLanguage.g:3380:4: (lv_type_0_0= ruleTypeRule )
            // InternalDataDescriptionLanguage.g:3381:5: lv_type_0_0= ruleTypeRule
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

            // InternalDataDescriptionLanguage.g:3398:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:3399:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:3399:4: (lv_name_1_0= ruleStringOrId )
            // InternalDataDescriptionLanguage.g:3400:5: lv_name_1_0= ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:3421:1: entryRuleImportRule returns [EObject current=null] : iv_ruleImportRule= ruleImportRule EOF ;
    public final EObject entryRuleImportRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportRule = null;


        try {
            // InternalDataDescriptionLanguage.g:3421:51: (iv_ruleImportRule= ruleImportRule EOF )
            // InternalDataDescriptionLanguage.g:3422:2: iv_ruleImportRule= ruleImportRule EOF
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
    // InternalDataDescriptionLanguage.g:3428:1: ruleImportRule returns [EObject current=null] : (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' ) ;
    public final EObject ruleImportRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_language_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_importedNamespace_3_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3434:2: ( (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' ) )
            // InternalDataDescriptionLanguage.g:3435:2: (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' )
            {
            // InternalDataDescriptionLanguage.g:3435:2: (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' )
            // InternalDataDescriptionLanguage.g:3436:3: otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportRuleAccess().getImportKeyword_0());
              		
            }
            // InternalDataDescriptionLanguage.g:3440:3: ( (lv_language_1_0= RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:3441:4: (lv_language_1_0= RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:3441:4: (lv_language_1_0= RULE_STRING )
            // InternalDataDescriptionLanguage.g:3442:5: lv_language_1_0= RULE_STRING
            {
            lv_language_1_0=(Token)match(input,RULE_STRING,FOLLOW_46); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,53,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getImportRuleAccess().getFromKeyword_2());
              		
            }
            // InternalDataDescriptionLanguage.g:3462:3: ( (lv_importedNamespace_3_0= ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:3463:4: (lv_importedNamespace_3_0= ruleQualifiedName )
            {
            // InternalDataDescriptionLanguage.g:3463:4: (lv_importedNamespace_3_0= ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:3464:5: lv_importedNamespace_3_0= ruleQualifiedName
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


    // $ANTLR start "entryRuleFunctionNameRule"
    // InternalDataDescriptionLanguage.g:3489:1: entryRuleFunctionNameRule returns [EObject current=null] : iv_ruleFunctionNameRule= ruleFunctionNameRule EOF ;
    public final EObject entryRuleFunctionNameRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionNameRule = null;


        try {
            // InternalDataDescriptionLanguage.g:3489:57: (iv_ruleFunctionNameRule= ruleFunctionNameRule EOF )
            // InternalDataDescriptionLanguage.g:3490:2: iv_ruleFunctionNameRule= ruleFunctionNameRule EOF
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
    // InternalDataDescriptionLanguage.g:3496:1: ruleFunctionNameRule returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleFunctionNameRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3502:2: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDescriptionLanguage.g:3503:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDescriptionLanguage.g:3503:2: ( ( ruleQualifiedName ) )
            // InternalDataDescriptionLanguage.g:3504:3: ( ruleQualifiedName )
            {
            // InternalDataDescriptionLanguage.g:3504:3: ( ruleQualifiedName )
            // InternalDataDescriptionLanguage.g:3505:4: ruleQualifiedName
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
    // InternalDataDescriptionLanguage.g:3525:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalDataDescriptionLanguage.g:3525:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalDataDescriptionLanguage.g:3526:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalDataDescriptionLanguage.g:3532:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_StringOrId_0 = null;

        AntlrDatatypeRuleToken this_StringOrId_2 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3538:2: ( (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) )
            // InternalDataDescriptionLanguage.g:3539:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            {
            // InternalDataDescriptionLanguage.g:3539:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            // InternalDataDescriptionLanguage.g:3540:3: this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_47);
            this_StringOrId_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_StringOrId_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalDataDescriptionLanguage.g:3550:3: (kw= '.' this_StringOrId_2= ruleStringOrId )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==54) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:3551:4: kw= '.' this_StringOrId_2= ruleStringOrId
            	    {
            	    kw=(Token)match(input,54,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_47);
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
            	    break loop51;
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
    // InternalDataDescriptionLanguage.g:3571:1: entryRuleStringOrId returns [String current=null] : iv_ruleStringOrId= ruleStringOrId EOF ;
    public final String entryRuleStringOrId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringOrId = null;


        try {
            // InternalDataDescriptionLanguage.g:3571:50: (iv_ruleStringOrId= ruleStringOrId EOF )
            // InternalDataDescriptionLanguage.g:3572:2: iv_ruleStringOrId= ruleStringOrId EOF
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
    // InternalDataDescriptionLanguage.g:3578:1: ruleStringOrId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleStringOrId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_QUOTED_ID_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3584:2: ( (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) )
            // InternalDataDescriptionLanguage.g:3585:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            {
            // InternalDataDescriptionLanguage.g:3585:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_QUOTED_ID) ) {
                alt52=1;
            }
            else if ( (LA52_0==RULE_ID) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3586:3: this_QUOTED_ID_0= RULE_QUOTED_ID
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
                    // InternalDataDescriptionLanguage.g:3594:3: this_ID_1= RULE_ID
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
    // InternalDataDescriptionLanguage.g:3605:1: ruleScaleType returns [Enumerator current=null] : ( (enumLiteral_0= 'nominal' ) | (enumLiteral_1= 'ordinal' ) | (enumLiteral_2= 'cardinal' ) | (enumLiteral_3= 'quotient' ) ) ;
    public final Enumerator ruleScaleType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3611:2: ( ( (enumLiteral_0= 'nominal' ) | (enumLiteral_1= 'ordinal' ) | (enumLiteral_2= 'cardinal' ) | (enumLiteral_3= 'quotient' ) ) )
            // InternalDataDescriptionLanguage.g:3612:2: ( (enumLiteral_0= 'nominal' ) | (enumLiteral_1= 'ordinal' ) | (enumLiteral_2= 'cardinal' ) | (enumLiteral_3= 'quotient' ) )
            {
            // InternalDataDescriptionLanguage.g:3612:2: ( (enumLiteral_0= 'nominal' ) | (enumLiteral_1= 'ordinal' ) | (enumLiteral_2= 'cardinal' ) | (enumLiteral_3= 'quotient' ) )
            int alt53=4;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt53=1;
                }
                break;
            case 56:
                {
                alt53=2;
                }
                break;
            case 57:
                {
                alt53=3;
                }
                break;
            case 58:
                {
                alt53=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3613:3: (enumLiteral_0= 'nominal' )
                    {
                    // InternalDataDescriptionLanguage.g:3613:3: (enumLiteral_0= 'nominal' )
                    // InternalDataDescriptionLanguage.g:3614:4: enumLiteral_0= 'nominal'
                    {
                    enumLiteral_0=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getScaleTypeAccess().getNominalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getScaleTypeAccess().getNominalEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:3621:3: (enumLiteral_1= 'ordinal' )
                    {
                    // InternalDataDescriptionLanguage.g:3621:3: (enumLiteral_1= 'ordinal' )
                    // InternalDataDescriptionLanguage.g:3622:4: enumLiteral_1= 'ordinal'
                    {
                    enumLiteral_1=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getScaleTypeAccess().getOrdinalEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getScaleTypeAccess().getOrdinalEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:3629:3: (enumLiteral_2= 'cardinal' )
                    {
                    // InternalDataDescriptionLanguage.g:3629:3: (enumLiteral_2= 'cardinal' )
                    // InternalDataDescriptionLanguage.g:3630:4: enumLiteral_2= 'cardinal'
                    {
                    enumLiteral_2=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getScaleTypeAccess().getCardinalEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getScaleTypeAccess().getCardinalEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:3637:3: (enumLiteral_3= 'quotient' )
                    {
                    // InternalDataDescriptionLanguage.g:3637:3: (enumLiteral_3= 'quotient' )
                    // InternalDataDescriptionLanguage.g:3638:4: enumLiteral_3= 'quotient'
                    {
                    enumLiteral_3=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:3648:1: ruleRepresentationType returns [Enumerator current=null] : ( (enumLiteral_0= 'real' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'string' ) ) ;
    public final Enumerator ruleRepresentationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3654:2: ( ( (enumLiteral_0= 'real' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'string' ) ) )
            // InternalDataDescriptionLanguage.g:3655:2: ( (enumLiteral_0= 'real' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'string' ) )
            {
            // InternalDataDescriptionLanguage.g:3655:2: ( (enumLiteral_0= 'real' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'string' ) )
            int alt54=4;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt54=1;
                }
                break;
            case 59:
                {
                alt54=2;
                }
                break;
            case 49:
                {
                alt54=3;
                }
                break;
            case 45:
                {
                alt54=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3656:3: (enumLiteral_0= 'real' )
                    {
                    // InternalDataDescriptionLanguage.g:3656:3: (enumLiteral_0= 'real' )
                    // InternalDataDescriptionLanguage.g:3657:4: enumLiteral_0= 'real'
                    {
                    enumLiteral_0=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRepresentationTypeAccess().getRealEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRepresentationTypeAccess().getRealEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:3664:3: (enumLiteral_1= 'integer' )
                    {
                    // InternalDataDescriptionLanguage.g:3664:3: (enumLiteral_1= 'integer' )
                    // InternalDataDescriptionLanguage.g:3665:4: enumLiteral_1= 'integer'
                    {
                    enumLiteral_1=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRepresentationTypeAccess().getIntegerEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRepresentationTypeAccess().getIntegerEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:3672:3: (enumLiteral_2= 'boolean' )
                    {
                    // InternalDataDescriptionLanguage.g:3672:3: (enumLiteral_2= 'boolean' )
                    // InternalDataDescriptionLanguage.g:3673:4: enumLiteral_2= 'boolean'
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
                    // InternalDataDescriptionLanguage.g:3680:3: (enumLiteral_3= 'string' )
                    {
                    // InternalDataDescriptionLanguage.g:3680:3: (enumLiteral_3= 'string' )
                    // InternalDataDescriptionLanguage.g:3681:4: enumLiteral_3= 'string'
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
    // InternalDataDescriptionLanguage.g:3691:1: ruleComparisonOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) ;
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
            // InternalDataDescriptionLanguage.g:3697:2: ( ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) )
            // InternalDataDescriptionLanguage.g:3698:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalDataDescriptionLanguage.g:3698:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            int alt55=6;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt55=1;
                }
                break;
            case 61:
                {
                alt55=2;
                }
                break;
            case 62:
                {
                alt55=3;
                }
                break;
            case 63:
                {
                alt55=4;
                }
                break;
            case 64:
                {
                alt55=5;
                }
                break;
            case 65:
                {
                alt55=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3699:3: (enumLiteral_0= '>=' )
                    {
                    // InternalDataDescriptionLanguage.g:3699:3: (enumLiteral_0= '>=' )
                    // InternalDataDescriptionLanguage.g:3700:4: enumLiteral_0= '>='
                    {
                    enumLiteral_0=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:3707:3: (enumLiteral_1= '>' )
                    {
                    // InternalDataDescriptionLanguage.g:3707:3: (enumLiteral_1= '>' )
                    // InternalDataDescriptionLanguage.g:3708:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:3715:3: (enumLiteral_2= '=' )
                    {
                    // InternalDataDescriptionLanguage.g:3715:3: (enumLiteral_2= '=' )
                    // InternalDataDescriptionLanguage.g:3716:4: enumLiteral_2= '='
                    {
                    enumLiteral_2=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:3723:3: (enumLiteral_3= '!=' )
                    {
                    // InternalDataDescriptionLanguage.g:3723:3: (enumLiteral_3= '!=' )
                    // InternalDataDescriptionLanguage.g:3724:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalDataDescriptionLanguage.g:3731:3: (enumLiteral_4= '<' )
                    {
                    // InternalDataDescriptionLanguage.g:3731:3: (enumLiteral_4= '<' )
                    // InternalDataDescriptionLanguage.g:3732:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalDataDescriptionLanguage.g:3739:3: (enumLiteral_5= '<=' )
                    {
                    // InternalDataDescriptionLanguage.g:3739:3: (enumLiteral_5= '<=' )
                    // InternalDataDescriptionLanguage.g:3740:4: enumLiteral_5= '<='
                    {
                    enumLiteral_5=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:3750:1: ruleAddOrSubtractOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOrSubtractOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3756:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalDataDescriptionLanguage.g:3757:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalDataDescriptionLanguage.g:3757:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==66) ) {
                alt56=1;
            }
            else if ( (LA56_0==67) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3758:3: (enumLiteral_0= '+' )
                    {
                    // InternalDataDescriptionLanguage.g:3758:3: (enumLiteral_0= '+' )
                    // InternalDataDescriptionLanguage.g:3759:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:3766:3: (enumLiteral_1= '-' )
                    {
                    // InternalDataDescriptionLanguage.g:3766:3: (enumLiteral_1= '-' )
                    // InternalDataDescriptionLanguage.g:3767:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:3777:1: ruleMultiplyDivideModuloOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:3783:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalDataDescriptionLanguage.g:3784:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalDataDescriptionLanguage.g:3784:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt57=3;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt57=1;
                }
                break;
            case 69:
                {
                alt57=2;
                }
                break;
            case 70:
                {
                alt57=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3785:3: (enumLiteral_0= '*' )
                    {
                    // InternalDataDescriptionLanguage.g:3785:3: (enumLiteral_0= '*' )
                    // InternalDataDescriptionLanguage.g:3786:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:3793:3: (enumLiteral_1= '/' )
                    {
                    // InternalDataDescriptionLanguage.g:3793:3: (enumLiteral_1= '/' )
                    // InternalDataDescriptionLanguage.g:3794:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:3801:3: (enumLiteral_2= '%' )
                    {
                    // InternalDataDescriptionLanguage.g:3801:3: (enumLiteral_2= '%' )
                    // InternalDataDescriptionLanguage.g:3802:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:3812:1: ruleFactorRule returns [Enumerator current=null] : ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) ;
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
            // InternalDataDescriptionLanguage.g:3818:2: ( ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) )
            // InternalDataDescriptionLanguage.g:3819:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            {
            // InternalDataDescriptionLanguage.g:3819:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            int alt58=20;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt58=1;
                }
                break;
            case 72:
                {
                alt58=2;
                }
                break;
            case 73:
                {
                alt58=3;
                }
                break;
            case 74:
                {
                alt58=4;
                }
                break;
            case 75:
                {
                alt58=5;
                }
                break;
            case 76:
                {
                alt58=6;
                }
                break;
            case 77:
                {
                alt58=7;
                }
                break;
            case 78:
                {
                alt58=8;
                }
                break;
            case 79:
                {
                alt58=9;
                }
                break;
            case 80:
                {
                alt58=10;
                }
                break;
            case 81:
                {
                alt58=11;
                }
                break;
            case 82:
                {
                alt58=12;
                }
                break;
            case 83:
                {
                alt58=13;
                }
                break;
            case 84:
                {
                alt58=14;
                }
                break;
            case 85:
                {
                alt58=15;
                }
                break;
            case 86:
                {
                alt58=16;
                }
                break;
            case 87:
                {
                alt58=17;
                }
                break;
            case 88:
                {
                alt58=18;
                }
                break;
            case 89:
                {
                alt58=19;
                }
                break;
            case 90:
                {
                alt58=20;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:3820:3: (enumLiteral_0= 'Y' )
                    {
                    // InternalDataDescriptionLanguage.g:3820:3: (enumLiteral_0= 'Y' )
                    // InternalDataDescriptionLanguage.g:3821:4: enumLiteral_0= 'Y'
                    {
                    enumLiteral_0=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:3828:3: (enumLiteral_1= 'Z' )
                    {
                    // InternalDataDescriptionLanguage.g:3828:3: (enumLiteral_1= 'Z' )
                    // InternalDataDescriptionLanguage.g:3829:4: enumLiteral_1= 'Z'
                    {
                    enumLiteral_1=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:3836:3: (enumLiteral_2= 'E' )
                    {
                    // InternalDataDescriptionLanguage.g:3836:3: (enumLiteral_2= 'E' )
                    // InternalDataDescriptionLanguage.g:3837:4: enumLiteral_2= 'E'
                    {
                    enumLiteral_2=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:3844:3: (enumLiteral_3= 'P' )
                    {
                    // InternalDataDescriptionLanguage.g:3844:3: (enumLiteral_3= 'P' )
                    // InternalDataDescriptionLanguage.g:3845:4: enumLiteral_3= 'P'
                    {
                    enumLiteral_3=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalDataDescriptionLanguage.g:3852:3: (enumLiteral_4= 'T' )
                    {
                    // InternalDataDescriptionLanguage.g:3852:3: (enumLiteral_4= 'T' )
                    // InternalDataDescriptionLanguage.g:3853:4: enumLiteral_4= 'T'
                    {
                    enumLiteral_4=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalDataDescriptionLanguage.g:3860:3: (enumLiteral_5= 'G' )
                    {
                    // InternalDataDescriptionLanguage.g:3860:3: (enumLiteral_5= 'G' )
                    // InternalDataDescriptionLanguage.g:3861:4: enumLiteral_5= 'G'
                    {
                    enumLiteral_5=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalDataDescriptionLanguage.g:3868:3: (enumLiteral_6= 'M' )
                    {
                    // InternalDataDescriptionLanguage.g:3868:3: (enumLiteral_6= 'M' )
                    // InternalDataDescriptionLanguage.g:3869:4: enumLiteral_6= 'M'
                    {
                    enumLiteral_6=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalDataDescriptionLanguage.g:3876:3: (enumLiteral_7= 'k' )
                    {
                    // InternalDataDescriptionLanguage.g:3876:3: (enumLiteral_7= 'k' )
                    // InternalDataDescriptionLanguage.g:3877:4: enumLiteral_7= 'k'
                    {
                    enumLiteral_7=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalDataDescriptionLanguage.g:3884:3: (enumLiteral_8= 'h' )
                    {
                    // InternalDataDescriptionLanguage.g:3884:3: (enumLiteral_8= 'h' )
                    // InternalDataDescriptionLanguage.g:3885:4: enumLiteral_8= 'h'
                    {
                    enumLiteral_8=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalDataDescriptionLanguage.g:3892:3: (enumLiteral_9= 'da' )
                    {
                    // InternalDataDescriptionLanguage.g:3892:3: (enumLiteral_9= 'da' )
                    // InternalDataDescriptionLanguage.g:3893:4: enumLiteral_9= 'da'
                    {
                    enumLiteral_9=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalDataDescriptionLanguage.g:3900:3: (enumLiteral_10= 'd' )
                    {
                    // InternalDataDescriptionLanguage.g:3900:3: (enumLiteral_10= 'd' )
                    // InternalDataDescriptionLanguage.g:3901:4: enumLiteral_10= 'd'
                    {
                    enumLiteral_10=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_10, grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10());
                      			
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalDataDescriptionLanguage.g:3908:3: (enumLiteral_11= 'c' )
                    {
                    // InternalDataDescriptionLanguage.g:3908:3: (enumLiteral_11= 'c' )
                    // InternalDataDescriptionLanguage.g:3909:4: enumLiteral_11= 'c'
                    {
                    enumLiteral_11=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_11, grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11());
                      			
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalDataDescriptionLanguage.g:3916:3: (enumLiteral_12= 'm' )
                    {
                    // InternalDataDescriptionLanguage.g:3916:3: (enumLiteral_12= 'm' )
                    // InternalDataDescriptionLanguage.g:3917:4: enumLiteral_12= 'm'
                    {
                    enumLiteral_12=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_12, grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12());
                      			
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalDataDescriptionLanguage.g:3924:3: (enumLiteral_13= '\\u00B5' )
                    {
                    // InternalDataDescriptionLanguage.g:3924:3: (enumLiteral_13= '\\u00B5' )
                    // InternalDataDescriptionLanguage.g:3925:4: enumLiteral_13= '\\u00B5'
                    {
                    enumLiteral_13=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_13, grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13());
                      			
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalDataDescriptionLanguage.g:3932:3: (enumLiteral_14= 'n' )
                    {
                    // InternalDataDescriptionLanguage.g:3932:3: (enumLiteral_14= 'n' )
                    // InternalDataDescriptionLanguage.g:3933:4: enumLiteral_14= 'n'
                    {
                    enumLiteral_14=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_14, grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14());
                      			
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalDataDescriptionLanguage.g:3940:3: (enumLiteral_15= 'p' )
                    {
                    // InternalDataDescriptionLanguage.g:3940:3: (enumLiteral_15= 'p' )
                    // InternalDataDescriptionLanguage.g:3941:4: enumLiteral_15= 'p'
                    {
                    enumLiteral_15=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_15, grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15());
                      			
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalDataDescriptionLanguage.g:3948:3: (enumLiteral_16= 'f' )
                    {
                    // InternalDataDescriptionLanguage.g:3948:3: (enumLiteral_16= 'f' )
                    // InternalDataDescriptionLanguage.g:3949:4: enumLiteral_16= 'f'
                    {
                    enumLiteral_16=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_16, grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16());
                      			
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalDataDescriptionLanguage.g:3956:3: (enumLiteral_17= 'a' )
                    {
                    // InternalDataDescriptionLanguage.g:3956:3: (enumLiteral_17= 'a' )
                    // InternalDataDescriptionLanguage.g:3957:4: enumLiteral_17= 'a'
                    {
                    enumLiteral_17=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_17, grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17());
                      			
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalDataDescriptionLanguage.g:3964:3: (enumLiteral_18= 'z' )
                    {
                    // InternalDataDescriptionLanguage.g:3964:3: (enumLiteral_18= 'z' )
                    // InternalDataDescriptionLanguage.g:3965:4: enumLiteral_18= 'z'
                    {
                    enumLiteral_18=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_18, grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18());
                      			
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalDataDescriptionLanguage.g:3972:3: (enumLiteral_19= 'y' )
                    {
                    // InternalDataDescriptionLanguage.g:3972:3: (enumLiteral_19= 'y' )
                    // InternalDataDescriptionLanguage.g:3973:4: enumLiteral_19= 'y'
                    {
                    enumLiteral_19=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
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

    // $ANTLR start synpred8_InternalDataDescriptionLanguage
    public final void synpred8_InternalDataDescriptionLanguage_fragment() throws RecognitionException {   
        EObject this_BaseDataTypeDefinitionRule_0 = null;


        // InternalDataDescriptionLanguage.g:243:3: (this_BaseDataTypeDefinitionRule_0= ruleBaseDataTypeDefinitionRule )
        // InternalDataDescriptionLanguage.g:243:3: this_BaseDataTypeDefinitionRule_0= ruleBaseDataTypeDefinitionRule
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_BaseDataTypeDefinitionRule_0=ruleBaseDataTypeDefinitionRule();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_InternalDataDescriptionLanguage

    // $ANTLR start synpred18_InternalDataDescriptionLanguage
    public final void synpred18_InternalDataDescriptionLanguage_fragment() throws RecognitionException {   
        EObject this_TypedBaseDataDescriptionRule_0 = null;


        // InternalDataDescriptionLanguage.g:663:3: (this_TypedBaseDataDescriptionRule_0= ruleTypedBaseDataDescriptionRule )
        // InternalDataDescriptionLanguage.g:663:3: this_TypedBaseDataDescriptionRule_0= ruleTypedBaseDataDescriptionRule
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_TypedBaseDataDescriptionRule_0=ruleTypedBaseDataDescriptionRule();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_InternalDataDescriptionLanguage

    // $ANTLR start synpred19_InternalDataDescriptionLanguage
    public final void synpred19_InternalDataDescriptionLanguage_fragment() throws RecognitionException {   
        EObject this_UntypedBaseDataDescriptionRule_1 = null;


        // InternalDataDescriptionLanguage.g:675:3: (this_UntypedBaseDataDescriptionRule_1= ruleUntypedBaseDataDescriptionRule )
        // InternalDataDescriptionLanguage.g:675:3: this_UntypedBaseDataDescriptionRule_1= ruleUntypedBaseDataDescriptionRule
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_UntypedBaseDataDescriptionRule_1=ruleUntypedBaseDataDescriptionRule();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_InternalDataDescriptionLanguage

    // $ANTLR start synpred45_InternalDataDescriptionLanguage
    public final void synpred45_InternalDataDescriptionLanguage_fragment() throws RecognitionException {   
        EObject this_LiteralRule_2 = null;


        // InternalDataDescriptionLanguage.g:2060:3: (this_LiteralRule_2= ruleLiteralRule )
        // InternalDataDescriptionLanguage.g:2060:3: this_LiteralRule_2= ruleLiteralRule
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
    // $ANTLR end synpred45_InternalDataDescriptionLanguage

    // Delegated rules

    public final boolean synpred19_InternalDataDescriptionLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalDataDescriptionLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalDataDescriptionLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalDataDescriptionLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_InternalDataDescriptionLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_InternalDataDescriptionLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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


    protected DFA18 dfa18 = new DFA18(this);
    protected DFA28 dfa28 = new DFA28(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\1\23\5\0\6\uffff";
    static final String dfa_3s = "\1\73\5\0\6\uffff";
    static final String dfa_4s = "\6\uffff\1\2\3\uffff\1\3\1\1";
    static final String dfa_5s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\6\uffff}>";
    static final String[] dfa_6s = {
            "\1\12\27\uffff\1\1\1\uffff\1\5\2\uffff\1\2\1\4\5\uffff\4\6\1\3",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "662:2: (this_TypedBaseDataDescriptionRule_0= ruleTypedBaseDataDescriptionRule | this_UntypedBaseDataDescriptionRule_1= ruleUntypedBaseDataDescriptionRule | this_StructuredDataDescriptionRule_2= ruleStructuredDataDescriptionRule )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_1 = input.LA(1);

                         
                        int index18_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalDataDescriptionLanguage()) ) {s = 11;}

                        else if ( (synpred19_InternalDataDescriptionLanguage()) ) {s = 6;}

                         
                        input.seek(index18_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA18_2 = input.LA(1);

                         
                        int index18_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalDataDescriptionLanguage()) ) {s = 11;}

                        else if ( (synpred19_InternalDataDescriptionLanguage()) ) {s = 6;}

                         
                        input.seek(index18_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA18_3 = input.LA(1);

                         
                        int index18_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalDataDescriptionLanguage()) ) {s = 11;}

                        else if ( (synpred19_InternalDataDescriptionLanguage()) ) {s = 6;}

                         
                        input.seek(index18_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA18_4 = input.LA(1);

                         
                        int index18_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalDataDescriptionLanguage()) ) {s = 11;}

                        else if ( (synpred19_InternalDataDescriptionLanguage()) ) {s = 6;}

                         
                        input.seek(index18_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA18_5 = input.LA(1);

                         
                        int index18_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalDataDescriptionLanguage()) ) {s = 11;}

                        else if ( (synpred19_InternalDataDescriptionLanguage()) ) {s = 6;}

                         
                        input.seek(index18_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 18, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\13\uffff";
    static final String dfa_8s = "\4\uffff\2\7\3\uffff\2\7";
    static final String dfa_9s = "\1\4\3\uffff\2\20\1\7\2\uffff\2\20";
    static final String dfa_10s = "\1\52\3\uffff\2\106\1\10\2\uffff\2\106";
    static final String dfa_11s = "\1\uffff\1\1\1\2\1\3\3\uffff\1\5\1\4\2\uffff";
    static final String dfa_12s = "\13\uffff}>";
    static final String[] dfa_13s = {
            "\1\2\2\1\1\4\1\5\40\uffff\2\3",
            "",
            "",
            "",
            "\1\10\10\uffff\1\7\2\uffff\2\7\3\uffff\3\7\1\uffff\1\7\1\uffff\1\7\16\uffff\1\6\5\uffff\13\7",
            "\1\10\10\uffff\1\7\2\uffff\2\7\3\uffff\3\7\1\uffff\1\7\1\uffff\1\7\16\uffff\1\6\5\uffff\13\7",
            "\1\11\1\12",
            "",
            "",
            "\1\10\10\uffff\1\7\2\uffff\2\7\3\uffff\3\7\1\uffff\1\7\1\uffff\1\7\16\uffff\1\6\5\uffff\13\7",
            "\1\10\10\uffff\1\7\2\uffff\2\7\3\uffff\3\7\1\uffff\1\7\1\uffff\1\7\16\uffff\1\6\5\uffff\13\7"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1298:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule | this_EnumLiteralReferenceRule_4= ruleEnumLiteralReferenceRule )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0010000000008000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000003A0000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0780080000380000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0F83280000380000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000651082801F0L,0x000000000000000CL});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0780080000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000006510A0801F0L,0x000000000000000CL});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0803280000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000004400000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0F83280000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000651080801F0L,0x000000000000000CL});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0xF000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000070L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x000006D1080801F0L,0x000000000000000CL});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000008010000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x00000651280801F0L,0x000000000000000CL});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000200180L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000002L,0x0000000007FFFF80L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000080000000180L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x000FF00080080000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000010002000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0040000000000002L});

}
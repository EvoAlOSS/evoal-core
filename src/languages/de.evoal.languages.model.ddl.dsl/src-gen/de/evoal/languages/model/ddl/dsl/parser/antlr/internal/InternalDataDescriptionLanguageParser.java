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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_QUOTED_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'types'", "':'", "'data'", "'constraints'", "'use'", "';'", "'type'", "'description'", "'with'", "'of'", "'value'", "'OR'", "'XOR'", "'AND'", "'!'", "'^'", "'('", "')'", "','", "'true'", "'false'", "'.'", "'nominal'", "'ordinal'", "'cardinal'", "'quotient'", "'real'", "'integer'", "'boolean'", "'string'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'"
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
    public static final int RULE_ID=5;
    public static final int RULE_QUOTED_ID=7;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
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
    // InternalDataDescriptionLanguage.g:79:1: ruleDataDescriptionModelRule returns [EObject current=null] : ( () ( (lv_uses_1_0= ruleUseRule ) )* (otherlv_2= 'types' otherlv_3= ':' ( (lv_types_4_0= ruleDataTypeRule ) )* )? (otherlv_5= 'data' otherlv_6= ':' ( (lv_descriptions_7_0= ruleDataDescriptionRule ) )* )? (otherlv_8= 'constraints' otherlv_9= ':' ( (lv_constraints_10_0= ruleStatementRule ) )* )? ) ;
    public final EObject ruleDataDescriptionModelRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_uses_1_0 = null;

        EObject lv_types_4_0 = null;

        EObject lv_descriptions_7_0 = null;

        EObject lv_constraints_10_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:85:2: ( ( () ( (lv_uses_1_0= ruleUseRule ) )* (otherlv_2= 'types' otherlv_3= ':' ( (lv_types_4_0= ruleDataTypeRule ) )* )? (otherlv_5= 'data' otherlv_6= ':' ( (lv_descriptions_7_0= ruleDataDescriptionRule ) )* )? (otherlv_8= 'constraints' otherlv_9= ':' ( (lv_constraints_10_0= ruleStatementRule ) )* )? ) )
            // InternalDataDescriptionLanguage.g:86:2: ( () ( (lv_uses_1_0= ruleUseRule ) )* (otherlv_2= 'types' otherlv_3= ':' ( (lv_types_4_0= ruleDataTypeRule ) )* )? (otherlv_5= 'data' otherlv_6= ':' ( (lv_descriptions_7_0= ruleDataDescriptionRule ) )* )? (otherlv_8= 'constraints' otherlv_9= ':' ( (lv_constraints_10_0= ruleStatementRule ) )* )? )
            {
            // InternalDataDescriptionLanguage.g:86:2: ( () ( (lv_uses_1_0= ruleUseRule ) )* (otherlv_2= 'types' otherlv_3= ':' ( (lv_types_4_0= ruleDataTypeRule ) )* )? (otherlv_5= 'data' otherlv_6= ':' ( (lv_descriptions_7_0= ruleDataDescriptionRule ) )* )? (otherlv_8= 'constraints' otherlv_9= ':' ( (lv_constraints_10_0= ruleStatementRule ) )* )? )
            // InternalDataDescriptionLanguage.g:87:3: () ( (lv_uses_1_0= ruleUseRule ) )* (otherlv_2= 'types' otherlv_3= ':' ( (lv_types_4_0= ruleDataTypeRule ) )* )? (otherlv_5= 'data' otherlv_6= ':' ( (lv_descriptions_7_0= ruleDataDescriptionRule ) )* )? (otherlv_8= 'constraints' otherlv_9= ':' ( (lv_constraints_10_0= ruleStatementRule ) )* )?
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

            // InternalDataDescriptionLanguage.g:97:3: ( (lv_uses_1_0= ruleUseRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:98:4: (lv_uses_1_0= ruleUseRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:98:4: (lv_uses_1_0= ruleUseRule )
            	    // InternalDataDescriptionLanguage.g:99:5: lv_uses_1_0= ruleUseRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getDataDescriptionModelRuleAccess().getUsesUseRuleParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_uses_1_0=ruleUseRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getDataDescriptionModelRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"uses",
            	      						lv_uses_1_0,
            	      						"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.UseRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalDataDescriptionLanguage.g:116:3: (otherlv_2= 'types' otherlv_3= ':' ( (lv_types_4_0= ruleDataTypeRule ) )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:117:4: otherlv_2= 'types' otherlv_3= ':' ( (lv_types_4_0= ruleDataTypeRule ) )*
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getDataDescriptionModelRuleAccess().getTypesKeyword_2_0());
                      			
                    }
                    otherlv_3=(Token)match(input,13,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_2_1());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:125:4: ( (lv_types_4_0= ruleDataTypeRule ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>=34 && LA2_0<=37)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:126:5: (lv_types_4_0= ruleDataTypeRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:126:5: (lv_types_4_0= ruleDataTypeRule )
                    	    // InternalDataDescriptionLanguage.g:127:6: lv_types_4_0= ruleDataTypeRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getDataDescriptionModelRuleAccess().getTypesDataTypeRuleParserRuleCall_2_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_5);
                    	    lv_types_4_0=ruleDataTypeRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getDataDescriptionModelRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"types",
                    	      							lv_types_4_0,
                    	      							"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.DataTypeRule");
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

            // InternalDataDescriptionLanguage.g:145:3: (otherlv_5= 'data' otherlv_6= ':' ( (lv_descriptions_7_0= ruleDataDescriptionRule ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:146:4: otherlv_5= 'data' otherlv_6= ':' ( (lv_descriptions_7_0= ruleDataDescriptionRule ) )*
                    {
                    otherlv_5=(Token)match(input,14,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getDataDescriptionModelRuleAccess().getDataKeyword_3_0());
                      			
                    }
                    otherlv_6=(Token)match(input,13,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_3_1());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:154:4: ( (lv_descriptions_7_0= ruleDataDescriptionRule ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=34 && LA4_0<=41)) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:155:5: (lv_descriptions_7_0= ruleDataDescriptionRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:155:5: (lv_descriptions_7_0= ruleDataDescriptionRule )
                    	    // InternalDataDescriptionLanguage.g:156:6: lv_descriptions_7_0= ruleDataDescriptionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getDataDescriptionModelRuleAccess().getDescriptionsDataDescriptionRuleParserRuleCall_3_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_6);
                    	    lv_descriptions_7_0=ruleDataDescriptionRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getDataDescriptionModelRuleRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"descriptions",
                    	      							lv_descriptions_7_0,
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

            // InternalDataDescriptionLanguage.g:174:3: (otherlv_8= 'constraints' otherlv_9= ':' ( (lv_constraints_10_0= ruleStatementRule ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:175:4: otherlv_8= 'constraints' otherlv_9= ':' ( (lv_constraints_10_0= ruleStatementRule ) )*
                    {
                    otherlv_8=(Token)match(input,15,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsKeyword_4_0());
                      			
                    }
                    otherlv_9=(Token)match(input,13,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getDataDescriptionModelRuleAccess().getColonKeyword_4_1());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:183:4: ( (lv_constraints_10_0= ruleStatementRule ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=RULE_STRING && LA6_0<=RULE_QUOTED_ID)||LA6_0==22||LA6_0==26||LA6_0==28||(LA6_0>=31 && LA6_0<=32)||(LA6_0>=48 && LA6_0<=49)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:184:5: (lv_constraints_10_0= ruleStatementRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:184:5: (lv_constraints_10_0= ruleStatementRule )
                    	    // InternalDataDescriptionLanguage.g:185:6: lv_constraints_10_0= ruleStatementRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getDataDescriptionModelRuleAccess().getConstraintsStatementRuleParserRuleCall_4_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_7);
                    	    lv_constraints_10_0=ruleStatementRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getDataDescriptionModelRuleRule());
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
                    	    break loop6;
                        }
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
    // $ANTLR end "ruleDataDescriptionModelRule"


    // $ANTLR start "entryRuleUseRule"
    // InternalDataDescriptionLanguage.g:207:1: entryRuleUseRule returns [EObject current=null] : iv_ruleUseRule= ruleUseRule EOF ;
    public final EObject entryRuleUseRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUseRule = null;


        try {
            // InternalDataDescriptionLanguage.g:207:48: (iv_ruleUseRule= ruleUseRule EOF )
            // InternalDataDescriptionLanguage.g:208:2: iv_ruleUseRule= ruleUseRule EOF
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
    // InternalDataDescriptionLanguage.g:214:1: ruleUseRule returns [EObject current=null] : (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' ) ;
    public final EObject ruleUseRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:220:2: ( (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' ) )
            // InternalDataDescriptionLanguage.g:221:2: (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' )
            {
            // InternalDataDescriptionLanguage.g:221:2: (otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' )
            // InternalDataDescriptionLanguage.g:222:3: otherlv_0= 'use' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getUseRuleAccess().getUseKeyword_0());
              		
            }
            // InternalDataDescriptionLanguage.g:226:3: ( (lv_importURI_1_0= RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:227:4: (lv_importURI_1_0= RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:227:4: (lv_importURI_1_0= RULE_STRING )
            // InternalDataDescriptionLanguage.g:228:5: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_9); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleDataTypeRule"
    // InternalDataDescriptionLanguage.g:252:1: entryRuleDataTypeRule returns [EObject current=null] : iv_ruleDataTypeRule= ruleDataTypeRule EOF ;
    public final EObject entryRuleDataTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeRule = null;


        try {
            // InternalDataDescriptionLanguage.g:252:53: (iv_ruleDataTypeRule= ruleDataTypeRule EOF )
            // InternalDataDescriptionLanguage.g:253:2: iv_ruleDataTypeRule= ruleDataTypeRule EOF
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
    // InternalDataDescriptionLanguage.g:259:1: ruleDataTypeRule returns [EObject current=null] : ( ( (lv_scale_0_0= ruleScaleType ) ) otherlv_1= 'type' ( (lv_name_2_0= ruleStringOrId ) ) (otherlv_3= 'description' otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) ) )? (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';' ) ;
    public final EObject ruleDataTypeRule() throws RecognitionException {
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
            // InternalDataDescriptionLanguage.g:265:2: ( ( ( (lv_scale_0_0= ruleScaleType ) ) otherlv_1= 'type' ( (lv_name_2_0= ruleStringOrId ) ) (otherlv_3= 'description' otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) ) )? (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';' ) )
            // InternalDataDescriptionLanguage.g:266:2: ( ( (lv_scale_0_0= ruleScaleType ) ) otherlv_1= 'type' ( (lv_name_2_0= ruleStringOrId ) ) (otherlv_3= 'description' otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) ) )? (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';' )
            {
            // InternalDataDescriptionLanguage.g:266:2: ( ( (lv_scale_0_0= ruleScaleType ) ) otherlv_1= 'type' ( (lv_name_2_0= ruleStringOrId ) ) (otherlv_3= 'description' otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) ) )? (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';' )
            // InternalDataDescriptionLanguage.g:267:3: ( (lv_scale_0_0= ruleScaleType ) ) otherlv_1= 'type' ( (lv_name_2_0= ruleStringOrId ) ) (otherlv_3= 'description' otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) ) )? (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';'
            {
            // InternalDataDescriptionLanguage.g:267:3: ( (lv_scale_0_0= ruleScaleType ) )
            // InternalDataDescriptionLanguage.g:268:4: (lv_scale_0_0= ruleScaleType )
            {
            // InternalDataDescriptionLanguage.g:268:4: (lv_scale_0_0= ruleScaleType )
            // InternalDataDescriptionLanguage.g:269:5: lv_scale_0_0= ruleScaleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDataTypeRuleAccess().getScaleScaleTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_10);
            lv_scale_0_0=ruleScaleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDataTypeRuleRule());
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

            otherlv_1=(Token)match(input,18,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDataTypeRuleAccess().getTypeKeyword_1());
              		
            }
            // InternalDataDescriptionLanguage.g:290:3: ( (lv_name_2_0= ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:291:4: (lv_name_2_0= ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:291:4: (lv_name_2_0= ruleStringOrId )
            // InternalDataDescriptionLanguage.g:292:5: lv_name_2_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDataTypeRuleAccess().getNameStringOrIdParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_12);
            lv_name_2_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDataTypeRuleRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_2_0,
              						"de.evoal.languages.model.el.dsl.ExpressionLanguage.StringOrId");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalDataDescriptionLanguage.g:309:3: (otherlv_3= 'description' otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:310:4: otherlv_3= 'description' otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getDataTypeRuleAccess().getDescriptionKeyword_3_0());
                      			
                    }
                    otherlv_4=(Token)match(input,13,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getDataTypeRuleAccess().getColonKeyword_3_1());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:318:4: ( (lv_description_5_0= RULE_STRING ) )
                    // InternalDataDescriptionLanguage.g:319:5: (lv_description_5_0= RULE_STRING )
                    {
                    // InternalDataDescriptionLanguage.g:319:5: (lv_description_5_0= RULE_STRING )
                    // InternalDataDescriptionLanguage.g:320:6: lv_description_5_0= RULE_STRING
                    {
                    lv_description_5_0=(Token)match(input,RULE_STRING,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_description_5_0, grammarAccess.getDataTypeRuleAccess().getDescriptionSTRINGTerminalRuleCall_3_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDataTypeRuleRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"description",
                      							lv_description_5_0,
                      							"de.evoal.languages.model.el.dsl.ExpressionLanguage.STRING");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalDataDescriptionLanguage.g:337:3: (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:338:4: otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )*
                    {
                    otherlv_6=(Token)match(input,20,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getDataTypeRuleAccess().getWithKeyword_4_0());
                      			
                    }
                    otherlv_7=(Token)match(input,15,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getDataTypeRuleAccess().getConstraintsKeyword_4_1());
                      			
                    }
                    otherlv_8=(Token)match(input,13,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getDataTypeRuleAccess().getColonKeyword_4_2());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:350:4: ( (lv_constraints_9_0= ruleStatementRule ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>=RULE_STRING && LA9_0<=RULE_QUOTED_ID)||LA9_0==22||LA9_0==26||LA9_0==28||(LA9_0>=31 && LA9_0<=32)||(LA9_0>=48 && LA9_0<=49)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:351:5: (lv_constraints_9_0= ruleStatementRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:351:5: (lv_constraints_9_0= ruleStatementRule )
                    	    // InternalDataDescriptionLanguage.g:352:6: lv_constraints_9_0= ruleStatementRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getDataTypeRuleAccess().getConstraintsStatementRuleParserRuleCall_4_3_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_15);
                    	    lv_constraints_9_0=ruleStatementRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getDataTypeRuleRule());
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

            otherlv_10=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getDataTypeRuleAccess().getSemicolonKeyword_5());
              		
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


    // $ANTLR start "entryRuleDataDescriptionRule"
    // InternalDataDescriptionLanguage.g:378:1: entryRuleDataDescriptionRule returns [EObject current=null] : iv_ruleDataDescriptionRule= ruleDataDescriptionRule EOF ;
    public final EObject entryRuleDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataDescriptionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:378:60: (iv_ruleDataDescriptionRule= ruleDataDescriptionRule EOF )
            // InternalDataDescriptionLanguage.g:379:2: iv_ruleDataDescriptionRule= ruleDataDescriptionRule EOF
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
    // InternalDataDescriptionLanguage.g:385:1: ruleDataDescriptionRule returns [EObject current=null] : (this_TypedDataDescriptionRule_0= ruleTypedDataDescriptionRule | this_UntypedDataDescriptionRule_1= ruleUntypedDataDescriptionRule ) ;
    public final EObject ruleDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        EObject this_TypedDataDescriptionRule_0 = null;

        EObject this_UntypedDataDescriptionRule_1 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:391:2: ( (this_TypedDataDescriptionRule_0= ruleTypedDataDescriptionRule | this_UntypedDataDescriptionRule_1= ruleUntypedDataDescriptionRule ) )
            // InternalDataDescriptionLanguage.g:392:2: (this_TypedDataDescriptionRule_0= ruleTypedDataDescriptionRule | this_UntypedDataDescriptionRule_1= ruleUntypedDataDescriptionRule )
            {
            // InternalDataDescriptionLanguage.g:392:2: (this_TypedDataDescriptionRule_0= ruleTypedDataDescriptionRule | this_UntypedDataDescriptionRule_1= ruleUntypedDataDescriptionRule )
            int alt11=2;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:393:3: this_TypedDataDescriptionRule_0= ruleTypedDataDescriptionRule
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
                    // InternalDataDescriptionLanguage.g:405:3: this_UntypedDataDescriptionRule_1= ruleUntypedDataDescriptionRule
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
    // InternalDataDescriptionLanguage.g:420:1: entryRuleTypedDataDescriptionRule returns [EObject current=null] : iv_ruleTypedDataDescriptionRule= ruleTypedDataDescriptionRule EOF ;
    public final EObject entryRuleTypedDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedDataDescriptionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:420:65: (iv_ruleTypedDataDescriptionRule= ruleTypedDataDescriptionRule EOF )
            // InternalDataDescriptionLanguage.g:421:2: iv_ruleTypedDataDescriptionRule= ruleTypedDataDescriptionRule EOF
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
    // InternalDataDescriptionLanguage.g:427:1: ruleTypedDataDescriptionRule returns [EObject current=null] : ( ( (lv_representation_0_0= ruleRepresentationType ) ) otherlv_1= 'data' ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= 'of' otherlv_4= 'type' ( (otherlv_5= RULE_ID ) ) (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';' ) ;
    public final EObject ruleTypedDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Enumerator lv_representation_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_constraints_9_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:433:2: ( ( ( (lv_representation_0_0= ruleRepresentationType ) ) otherlv_1= 'data' ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= 'of' otherlv_4= 'type' ( (otherlv_5= RULE_ID ) ) (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';' ) )
            // InternalDataDescriptionLanguage.g:434:2: ( ( (lv_representation_0_0= ruleRepresentationType ) ) otherlv_1= 'data' ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= 'of' otherlv_4= 'type' ( (otherlv_5= RULE_ID ) ) (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';' )
            {
            // InternalDataDescriptionLanguage.g:434:2: ( ( (lv_representation_0_0= ruleRepresentationType ) ) otherlv_1= 'data' ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= 'of' otherlv_4= 'type' ( (otherlv_5= RULE_ID ) ) (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';' )
            // InternalDataDescriptionLanguage.g:435:3: ( (lv_representation_0_0= ruleRepresentationType ) ) otherlv_1= 'data' ( (lv_name_2_0= ruleStringOrId ) ) otherlv_3= 'of' otherlv_4= 'type' ( (otherlv_5= RULE_ID ) ) (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )? otherlv_10= ';'
            {
            // InternalDataDescriptionLanguage.g:435:3: ( (lv_representation_0_0= ruleRepresentationType ) )
            // InternalDataDescriptionLanguage.g:436:4: (lv_representation_0_0= ruleRepresentationType )
            {
            // InternalDataDescriptionLanguage.g:436:4: (lv_representation_0_0= ruleRepresentationType )
            // InternalDataDescriptionLanguage.g:437:5: lv_representation_0_0= ruleRepresentationType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypedDataDescriptionRuleAccess().getRepresentationRepresentationTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_16);
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

            otherlv_1=(Token)match(input,14,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getTypedDataDescriptionRuleAccess().getDataKeyword_1());
              		
            }
            // InternalDataDescriptionLanguage.g:458:3: ( (lv_name_2_0= ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:459:4: (lv_name_2_0= ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:459:4: (lv_name_2_0= ruleStringOrId )
            // InternalDataDescriptionLanguage.g:460:5: lv_name_2_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypedDataDescriptionRuleAccess().getNameStringOrIdParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_17);
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
              						"de.evoal.languages.model.el.dsl.ExpressionLanguage.StringOrId");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getTypedDataDescriptionRuleAccess().getOfKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,18,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getTypedDataDescriptionRuleAccess().getTypeKeyword_4());
              		
            }
            // InternalDataDescriptionLanguage.g:485:3: ( (otherlv_5= RULE_ID ) )
            // InternalDataDescriptionLanguage.g:486:4: (otherlv_5= RULE_ID )
            {
            // InternalDataDescriptionLanguage.g:486:4: (otherlv_5= RULE_ID )
            // InternalDataDescriptionLanguage.g:487:5: otherlv_5= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTypedDataDescriptionRuleRule());
              					}
              				
            }
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_5, grammarAccess.getTypedDataDescriptionRuleAccess().getTypeDataTypeCrossReference_5_0());
              				
            }

            }


            }

            // InternalDataDescriptionLanguage.g:501:3: (otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:502:4: otherlv_6= 'with' otherlv_7= 'constraints' otherlv_8= ':' ( (lv_constraints_9_0= ruleStatementRule ) )*
                    {
                    otherlv_6=(Token)match(input,20,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getTypedDataDescriptionRuleAccess().getWithKeyword_6_0());
                      			
                    }
                    otherlv_7=(Token)match(input,15,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getTypedDataDescriptionRuleAccess().getConstraintsKeyword_6_1());
                      			
                    }
                    otherlv_8=(Token)match(input,13,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getTypedDataDescriptionRuleAccess().getColonKeyword_6_2());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:514:4: ( (lv_constraints_9_0= ruleStatementRule ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=RULE_STRING && LA12_0<=RULE_QUOTED_ID)||LA12_0==22||LA12_0==26||LA12_0==28||(LA12_0>=31 && LA12_0<=32)||(LA12_0>=48 && LA12_0<=49)) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:515:5: (lv_constraints_9_0= ruleStatementRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:515:5: (lv_constraints_9_0= ruleStatementRule )
                    	    // InternalDataDescriptionLanguage.g:516:6: lv_constraints_9_0= ruleStatementRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getTypedDataDescriptionRuleAccess().getConstraintsStatementRuleParserRuleCall_6_3_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_15);
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

            otherlv_10=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:542:1: entryRuleUntypedDataDescriptionRule returns [EObject current=null] : iv_ruleUntypedDataDescriptionRule= ruleUntypedDataDescriptionRule EOF ;
    public final EObject entryRuleUntypedDataDescriptionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUntypedDataDescriptionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:542:67: (iv_ruleUntypedDataDescriptionRule= ruleUntypedDataDescriptionRule EOF )
            // InternalDataDescriptionLanguage.g:543:2: iv_ruleUntypedDataDescriptionRule= ruleUntypedDataDescriptionRule EOF
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
    // InternalDataDescriptionLanguage.g:549:1: ruleUntypedDataDescriptionRule returns [EObject current=null] : ( ( (lv_scale_0_0= ruleScaleType ) )? ( (lv_representation_1_0= ruleRepresentationType ) ) otherlv_2= 'data' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'with' otherlv_5= 'constraints' otherlv_6= ':' ( (lv_constraints_7_0= ruleStatementRule ) )* )? otherlv_8= ';' ) ;
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
            // InternalDataDescriptionLanguage.g:555:2: ( ( ( (lv_scale_0_0= ruleScaleType ) )? ( (lv_representation_1_0= ruleRepresentationType ) ) otherlv_2= 'data' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'with' otherlv_5= 'constraints' otherlv_6= ':' ( (lv_constraints_7_0= ruleStatementRule ) )* )? otherlv_8= ';' ) )
            // InternalDataDescriptionLanguage.g:556:2: ( ( (lv_scale_0_0= ruleScaleType ) )? ( (lv_representation_1_0= ruleRepresentationType ) ) otherlv_2= 'data' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'with' otherlv_5= 'constraints' otherlv_6= ':' ( (lv_constraints_7_0= ruleStatementRule ) )* )? otherlv_8= ';' )
            {
            // InternalDataDescriptionLanguage.g:556:2: ( ( (lv_scale_0_0= ruleScaleType ) )? ( (lv_representation_1_0= ruleRepresentationType ) ) otherlv_2= 'data' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'with' otherlv_5= 'constraints' otherlv_6= ':' ( (lv_constraints_7_0= ruleStatementRule ) )* )? otherlv_8= ';' )
            // InternalDataDescriptionLanguage.g:557:3: ( (lv_scale_0_0= ruleScaleType ) )? ( (lv_representation_1_0= ruleRepresentationType ) ) otherlv_2= 'data' ( (lv_name_3_0= ruleStringOrId ) ) (otherlv_4= 'with' otherlv_5= 'constraints' otherlv_6= ':' ( (lv_constraints_7_0= ruleStatementRule ) )* )? otherlv_8= ';'
            {
            // InternalDataDescriptionLanguage.g:557:3: ( (lv_scale_0_0= ruleScaleType ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=34 && LA14_0<=37)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:558:4: (lv_scale_0_0= ruleScaleType )
                    {
                    // InternalDataDescriptionLanguage.g:558:4: (lv_scale_0_0= ruleScaleType )
                    // InternalDataDescriptionLanguage.g:559:5: lv_scale_0_0= ruleScaleType
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getUntypedDataDescriptionRuleAccess().getScaleScaleTypeEnumRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_19);
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

            // InternalDataDescriptionLanguage.g:576:3: ( (lv_representation_1_0= ruleRepresentationType ) )
            // InternalDataDescriptionLanguage.g:577:4: (lv_representation_1_0= ruleRepresentationType )
            {
            // InternalDataDescriptionLanguage.g:577:4: (lv_representation_1_0= ruleRepresentationType )
            // InternalDataDescriptionLanguage.g:578:5: lv_representation_1_0= ruleRepresentationType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUntypedDataDescriptionRuleAccess().getRepresentationRepresentationTypeEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_16);
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

            otherlv_2=(Token)match(input,14,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getUntypedDataDescriptionRuleAccess().getDataKeyword_2());
              		
            }
            // InternalDataDescriptionLanguage.g:599:3: ( (lv_name_3_0= ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:600:4: (lv_name_3_0= ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:600:4: (lv_name_3_0= ruleStringOrId )
            // InternalDataDescriptionLanguage.g:601:5: lv_name_3_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUntypedDataDescriptionRuleAccess().getNameStringOrIdParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_13);
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
              						"de.evoal.languages.model.el.dsl.ExpressionLanguage.StringOrId");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalDataDescriptionLanguage.g:618:3: (otherlv_4= 'with' otherlv_5= 'constraints' otherlv_6= ':' ( (lv_constraints_7_0= ruleStatementRule ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==20) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:619:4: otherlv_4= 'with' otherlv_5= 'constraints' otherlv_6= ':' ( (lv_constraints_7_0= ruleStatementRule ) )*
                    {
                    otherlv_4=(Token)match(input,20,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getUntypedDataDescriptionRuleAccess().getWithKeyword_4_0());
                      			
                    }
                    otherlv_5=(Token)match(input,15,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getUntypedDataDescriptionRuleAccess().getConstraintsKeyword_4_1());
                      			
                    }
                    otherlv_6=(Token)match(input,13,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getUntypedDataDescriptionRuleAccess().getColonKeyword_4_2());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:631:4: ( (lv_constraints_7_0= ruleStatementRule ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>=RULE_STRING && LA15_0<=RULE_QUOTED_ID)||LA15_0==22||LA15_0==26||LA15_0==28||(LA15_0>=31 && LA15_0<=32)||(LA15_0>=48 && LA15_0<=49)) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:632:5: (lv_constraints_7_0= ruleStatementRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:632:5: (lv_constraints_7_0= ruleStatementRule )
                    	    // InternalDataDescriptionLanguage.g:633:6: lv_constraints_7_0= ruleStatementRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getUntypedDataDescriptionRuleAccess().getConstraintsStatementRuleParserRuleCall_4_3_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_15);
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

            otherlv_8=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:659:1: entryRuleStatementRule returns [EObject current=null] : iv_ruleStatementRule= ruleStatementRule EOF ;
    public final EObject entryRuleStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementRule = null;


        try {
            // InternalDataDescriptionLanguage.g:659:54: (iv_ruleStatementRule= ruleStatementRule EOF )
            // InternalDataDescriptionLanguage.g:660:2: iv_ruleStatementRule= ruleStatementRule EOF
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
    // InternalDataDescriptionLanguage.g:666:1: ruleStatementRule returns [EObject current=null] : (this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';' ) ;
    public final EObject ruleStatementRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_ExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:672:2: ( (this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';' ) )
            // InternalDataDescriptionLanguage.g:673:2: (this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';' )
            {
            // InternalDataDescriptionLanguage.g:673:2: (this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';' )
            // InternalDataDescriptionLanguage.g:674:3: this_ExpressionRule_0= ruleExpressionRule otherlv_1= ';'
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getStatementRuleAccess().getExpressionRuleParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_9);
            this_ExpressionRule_0=ruleExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ExpressionRule_0;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_1=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleFunctionNameRule"
    // InternalDataDescriptionLanguage.g:693:1: entryRuleFunctionNameRule returns [EObject current=null] : iv_ruleFunctionNameRule= ruleFunctionNameRule EOF ;
    public final EObject entryRuleFunctionNameRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionNameRule = null;


        try {
            // InternalDataDescriptionLanguage.g:693:57: (iv_ruleFunctionNameRule= ruleFunctionNameRule EOF )
            // InternalDataDescriptionLanguage.g:694:2: iv_ruleFunctionNameRule= ruleFunctionNameRule EOF
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
    // InternalDataDescriptionLanguage.g:700:1: ruleFunctionNameRule returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFunctionNameRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:706:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalDataDescriptionLanguage.g:707:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalDataDescriptionLanguage.g:707:2: ( (otherlv_0= RULE_ID ) )
            // InternalDataDescriptionLanguage.g:708:3: (otherlv_0= RULE_ID )
            {
            // InternalDataDescriptionLanguage.g:708:3: (otherlv_0= RULE_ID )
            // InternalDataDescriptionLanguage.g:709:4: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getFunctionNameRuleRule());
              				}
              			
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_0, grammarAccess.getFunctionNameRuleAccess().getDefinitionFunctionDefinitionCrossReference_0());
              			
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


    // $ANTLR start "entryRuleValueReferenceRule"
    // InternalDataDescriptionLanguage.g:726:1: entryRuleValueReferenceRule returns [EObject current=null] : iv_ruleValueReferenceRule= ruleValueReferenceRule EOF ;
    public final EObject entryRuleValueReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueReferenceRule = null;


        try {
            // InternalDataDescriptionLanguage.g:726:59: (iv_ruleValueReferenceRule= ruleValueReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:727:2: iv_ruleValueReferenceRule= ruleValueReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:733:1: ruleValueReferenceRule returns [EObject current=null] : (this_DataReferenceRule_0= ruleDataReferenceRule | this_SelfReferenceRule_1= ruleSelfReferenceRule ) ;
    public final EObject ruleValueReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_DataReferenceRule_0 = null;

        EObject this_SelfReferenceRule_1 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:739:2: ( (this_DataReferenceRule_0= ruleDataReferenceRule | this_SelfReferenceRule_1= ruleSelfReferenceRule ) )
            // InternalDataDescriptionLanguage.g:740:2: (this_DataReferenceRule_0= ruleDataReferenceRule | this_SelfReferenceRule_1= ruleSelfReferenceRule )
            {
            // InternalDataDescriptionLanguage.g:740:2: (this_DataReferenceRule_0= ruleDataReferenceRule | this_SelfReferenceRule_1= ruleSelfReferenceRule )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID||LA17_0==RULE_QUOTED_ID) ) {
                alt17=1;
            }
            else if ( (LA17_0==22) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:741:3: this_DataReferenceRule_0= ruleDataReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueReferenceRuleAccess().getDataReferenceRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DataReferenceRule_0=ruleDataReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DataReferenceRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:753:3: this_SelfReferenceRule_1= ruleSelfReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueReferenceRuleAccess().getSelfReferenceRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SelfReferenceRule_1=ruleSelfReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SelfReferenceRule_1;
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
    // $ANTLR end "ruleValueReferenceRule"


    // $ANTLR start "entryRuleDataReferenceRule"
    // InternalDataDescriptionLanguage.g:768:1: entryRuleDataReferenceRule returns [EObject current=null] : iv_ruleDataReferenceRule= ruleDataReferenceRule EOF ;
    public final EObject entryRuleDataReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataReferenceRule = null;


        try {
            // InternalDataDescriptionLanguage.g:768:58: (iv_ruleDataReferenceRule= ruleDataReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:769:2: iv_ruleDataReferenceRule= ruleDataReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:775:1: ruleDataReferenceRule returns [EObject current=null] : ( ( ruleStringOrId ) ) ;
    public final EObject ruleDataReferenceRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:781:2: ( ( ( ruleStringOrId ) ) )
            // InternalDataDescriptionLanguage.g:782:2: ( ( ruleStringOrId ) )
            {
            // InternalDataDescriptionLanguage.g:782:2: ( ( ruleStringOrId ) )
            // InternalDataDescriptionLanguage.g:783:3: ( ruleStringOrId )
            {
            // InternalDataDescriptionLanguage.g:783:3: ( ruleStringOrId )
            // InternalDataDescriptionLanguage.g:784:4: ruleStringOrId
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
    // InternalDataDescriptionLanguage.g:804:1: entryRuleSelfReferenceRule returns [EObject current=null] : iv_ruleSelfReferenceRule= ruleSelfReferenceRule EOF ;
    public final EObject entryRuleSelfReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfReferenceRule = null;


        try {
            // InternalDataDescriptionLanguage.g:804:58: (iv_ruleSelfReferenceRule= ruleSelfReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:805:2: iv_ruleSelfReferenceRule= ruleSelfReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:811:1: ruleSelfReferenceRule returns [EObject current=null] : ( () otherlv_1= 'value' ) ;
    public final EObject ruleSelfReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:817:2: ( ( () otherlv_1= 'value' ) )
            // InternalDataDescriptionLanguage.g:818:2: ( () otherlv_1= 'value' )
            {
            // InternalDataDescriptionLanguage.g:818:2: ( () otherlv_1= 'value' )
            // InternalDataDescriptionLanguage.g:819:3: () otherlv_1= 'value'
            {
            // InternalDataDescriptionLanguage.g:819:3: ()
            // InternalDataDescriptionLanguage.g:820:4: 
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

            otherlv_1=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:837:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:837:55: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:838:2: iv_ruleExpressionRule= ruleExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:844:1: ruleExpressionRule returns [EObject current=null] : this_OrExpressionRule_0= ruleOrExpressionRule ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:850:2: (this_OrExpressionRule_0= ruleOrExpressionRule )
            // InternalDataDescriptionLanguage.g:851:2: this_OrExpressionRule_0= ruleOrExpressionRule
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
    // InternalDataDescriptionLanguage.g:865:1: entryRuleOrExpressionRule returns [EObject current=null] : iv_ruleOrExpressionRule= ruleOrExpressionRule EOF ;
    public final EObject entryRuleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:865:57: (iv_ruleOrExpressionRule= ruleOrExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:866:2: iv_ruleOrExpressionRule= ruleOrExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:872:1: ruleOrExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) ;
    public final EObject ruleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:878:2: ( ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) )
            // InternalDataDescriptionLanguage.g:879:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            {
            // InternalDataDescriptionLanguage.g:879:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            // InternalDataDescriptionLanguage.g:880:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            {
            // InternalDataDescriptionLanguage.g:880:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) )
            // InternalDataDescriptionLanguage.g:881:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:881:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            // InternalDataDescriptionLanguage.g:882:5: lv_subExpressions_0_0= ruleXorExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_20);
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

            // InternalDataDescriptionLanguage.g:899:3: (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==23) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:900:4: otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,23,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0());
            	      			
            	    }
            	    // InternalDataDescriptionLanguage.g:904:4: ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    // InternalDataDescriptionLanguage.g:905:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:905:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    // InternalDataDescriptionLanguage.g:906:6: lv_subExpressions_2_0= ruleXorExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
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
    // InternalDataDescriptionLanguage.g:928:1: entryRuleXorExpressionRule returns [EObject current=null] : iv_ruleXorExpressionRule= ruleXorExpressionRule EOF ;
    public final EObject entryRuleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:928:58: (iv_ruleXorExpressionRule= ruleXorExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:929:2: iv_ruleXorExpressionRule= ruleXorExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:935:1: ruleXorExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) ;
    public final EObject ruleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:941:2: ( ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) )
            // InternalDataDescriptionLanguage.g:942:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            {
            // InternalDataDescriptionLanguage.g:942:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            // InternalDataDescriptionLanguage.g:943:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            {
            // InternalDataDescriptionLanguage.g:943:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) )
            // InternalDataDescriptionLanguage.g:944:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:944:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            // InternalDataDescriptionLanguage.g:945:5: lv_subExpressions_0_0= ruleAndExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_22);
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

            // InternalDataDescriptionLanguage.g:962:3: (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==24) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:963:4: otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,24,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0());
            	      			
            	    }
            	    // InternalDataDescriptionLanguage.g:967:4: ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    // InternalDataDescriptionLanguage.g:968:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:968:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    // InternalDataDescriptionLanguage.g:969:6: lv_subExpressions_2_0= ruleAndExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_22);
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
    // InternalDataDescriptionLanguage.g:991:1: entryRuleAndExpressionRule returns [EObject current=null] : iv_ruleAndExpressionRule= ruleAndExpressionRule EOF ;
    public final EObject entryRuleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:991:58: (iv_ruleAndExpressionRule= ruleAndExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:992:2: iv_ruleAndExpressionRule= ruleAndExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:998:1: ruleAndExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) ;
    public final EObject ruleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1004:2: ( ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) )
            // InternalDataDescriptionLanguage.g:1005:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            {
            // InternalDataDescriptionLanguage.g:1005:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            // InternalDataDescriptionLanguage.g:1006:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            {
            // InternalDataDescriptionLanguage.g:1006:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1007:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1007:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            // InternalDataDescriptionLanguage.g:1008:5: lv_subExpressions_0_0= ruleNotExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_23);
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

            // InternalDataDescriptionLanguage.g:1025:3: (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==25) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1026:4: otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0());
            	      			
            	    }
            	    // InternalDataDescriptionLanguage.g:1030:4: ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    // InternalDataDescriptionLanguage.g:1031:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1031:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    // InternalDataDescriptionLanguage.g:1032:6: lv_subExpressions_2_0= ruleNotExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_23);
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
    // InternalDataDescriptionLanguage.g:1054:1: entryRuleNotExpressionRule returns [EObject current=null] : iv_ruleNotExpressionRule= ruleNotExpressionRule EOF ;
    public final EObject entryRuleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1054:58: (iv_ruleNotExpressionRule= ruleNotExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1055:2: iv_ruleNotExpressionRule= ruleNotExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1061:1: ruleNotExpressionRule returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) ;
    public final EObject ruleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1067:2: ( ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) )
            // InternalDataDescriptionLanguage.g:1068:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            {
            // InternalDataDescriptionLanguage.g:1068:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            // InternalDataDescriptionLanguage.g:1069:3: ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            {
            // InternalDataDescriptionLanguage.g:1069:3: ( (lv_negated_0_0= '!' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==26) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1070:4: (lv_negated_0_0= '!' )
                    {
                    // InternalDataDescriptionLanguage.g:1070:4: (lv_negated_0_0= '!' )
                    // InternalDataDescriptionLanguage.g:1071:5: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,26,FOLLOW_21); if (state.failed) return current;
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

            // InternalDataDescriptionLanguage.g:1083:3: ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1084:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1084:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            // InternalDataDescriptionLanguage.g:1085:5: lv_operand_1_0= ruleComparisonExpressionRule
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
    // InternalDataDescriptionLanguage.g:1106:1: entryRuleComparisonExpressionRule returns [EObject current=null] : iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF ;
    public final EObject entryRuleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1106:65: (iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1107:2: iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1113:1: ruleComparisonExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) ;
    public final EObject ruleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        EObject lv_comparison_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1119:2: ( ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) )
            // InternalDataDescriptionLanguage.g:1120:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            {
            // InternalDataDescriptionLanguage.g:1120:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            // InternalDataDescriptionLanguage.g:1121:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            {
            // InternalDataDescriptionLanguage.g:1121:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1122:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1122:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:1123:5: lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_24);
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

            // InternalDataDescriptionLanguage.g:1140:3: ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=42 && LA22_0<=47)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1141:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1141:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    // InternalDataDescriptionLanguage.g:1142:5: lv_comparison_1_0= rulePartialComparisonExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_24);
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
    // InternalDataDescriptionLanguage.g:1163:1: entryRulePartialComparisonExpressionRule returns [EObject current=null] : iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF ;
    public final EObject entryRulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialComparisonExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1163:72: (iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1164:2: iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1170:1: rulePartialComparisonExpressionRule returns [EObject current=null] : ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) ;
    public final EObject rulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1176:2: ( ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) )
            // InternalDataDescriptionLanguage.g:1177:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            {
            // InternalDataDescriptionLanguage.g:1177:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            // InternalDataDescriptionLanguage.g:1178:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            {
            // InternalDataDescriptionLanguage.g:1178:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) )
            // InternalDataDescriptionLanguage.g:1179:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            {
            // InternalDataDescriptionLanguage.g:1179:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            // InternalDataDescriptionLanguage.g:1180:5: lv_operator_0_0= ruleComparisonOperatorRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_21);
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

            // InternalDataDescriptionLanguage.g:1197:3: ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1198:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1198:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:1199:5: lv_subExpression_1_0= ruleAddOrSubtractExpressionRule
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
    // InternalDataDescriptionLanguage.g:1220:1: entryRuleAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOrSubtractExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1220:68: (iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1221:2: iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1227:1: ruleAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) ;
    public final EObject ruleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1233:2: ( ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) )
            // InternalDataDescriptionLanguage.g:1234:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            {
            // InternalDataDescriptionLanguage.g:1234:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            // InternalDataDescriptionLanguage.g:1235:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            {
            // InternalDataDescriptionLanguage.g:1235:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1236:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1236:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            // InternalDataDescriptionLanguage.g:1237:5: lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_25);
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

            // InternalDataDescriptionLanguage.g:1254:3: ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=48 && LA23_0<=49)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1255:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    {
            	    // InternalDataDescriptionLanguage.g:1255:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) )
            	    // InternalDataDescriptionLanguage.g:1256:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1256:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    // InternalDataDescriptionLanguage.g:1257:6: lv_operators_1_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_21);
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

            	    // InternalDataDescriptionLanguage.g:1274:4: ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    // InternalDataDescriptionLanguage.g:1275:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1275:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    // InternalDataDescriptionLanguage.g:1276:6: lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_25);
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
    // InternalDataDescriptionLanguage.g:1298:1: entryRuleMultiplyDivideModuloExpressionRule returns [EObject current=null] : iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF ;
    public final EObject entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideModuloExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1298:75: (iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1299:2: iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1305:1: ruleMultiplyDivideModuloExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) ;
    public final EObject ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1311:2: ( ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) )
            // InternalDataDescriptionLanguage.g:1312:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            {
            // InternalDataDescriptionLanguage.g:1312:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            // InternalDataDescriptionLanguage.g:1313:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            {
            // InternalDataDescriptionLanguage.g:1313:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1314:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1314:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            // InternalDataDescriptionLanguage.g:1315:5: lv_leftOperand_0_0= rulePowerOfExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_26);
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

            // InternalDataDescriptionLanguage.g:1332:3: ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=50 && LA24_0<=52)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1333:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    {
            	    // InternalDataDescriptionLanguage.g:1333:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) )
            	    // InternalDataDescriptionLanguage.g:1334:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1334:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    // InternalDataDescriptionLanguage.g:1335:6: lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_21);
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

            	    // InternalDataDescriptionLanguage.g:1352:4: ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    // InternalDataDescriptionLanguage.g:1353:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1353:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    // InternalDataDescriptionLanguage.g:1354:6: lv_operands_2_0= rulePowerOfExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_26);
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
    // InternalDataDescriptionLanguage.g:1376:1: entryRulePowerOfExpressionRule returns [EObject current=null] : iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF ;
    public final EObject entryRulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerOfExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1376:62: (iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1377:2: iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1383:1: rulePowerOfExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) ;
    public final EObject rulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_leftOperand_0_0 = null;

        EObject lv_rightOperand_2_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1389:2: ( ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) )
            // InternalDataDescriptionLanguage.g:1390:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            {
            // InternalDataDescriptionLanguage.g:1390:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            // InternalDataDescriptionLanguage.g:1391:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            {
            // InternalDataDescriptionLanguage.g:1391:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1392:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1392:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            // InternalDataDescriptionLanguage.g:1393:5: lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_27);
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

            // InternalDataDescriptionLanguage.g:1410:3: (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==27) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1411:4: otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0());
                      			
                    }
                    // InternalDataDescriptionLanguage.g:1415:4: ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    // InternalDataDescriptionLanguage.g:1416:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    {
                    // InternalDataDescriptionLanguage.g:1416:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    // InternalDataDescriptionLanguage.g:1417:6: lv_rightOperand_2_0= rulePowerOfExpressionRule
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
    // InternalDataDescriptionLanguage.g:1439:1: entryRuleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryAddOrSubtractExpressionRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1439:73: (iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalDataDescriptionLanguage.g:1440:2: iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalDataDescriptionLanguage.g:1446:1: ruleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) ) ;
    public final EObject ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operators_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1452:2: ( ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) ) )
            // InternalDataDescriptionLanguage.g:1453:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) )
            {
            // InternalDataDescriptionLanguage.g:1453:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) ) )
            // InternalDataDescriptionLanguage.g:1454:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) )
            {
            // InternalDataDescriptionLanguage.g:1454:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=48 && LA26_0<=49)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalDataDescriptionLanguage.g:1455:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalDataDescriptionLanguage.g:1455:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    // InternalDataDescriptionLanguage.g:1456:5: lv_operators_0_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_21);
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
            	    break loop26;
                }
            } while (true);

            // InternalDataDescriptionLanguage.g:1473:3: ( (lv_subExpression_1_0= ruleLiteralOrReferenceRule ) )
            // InternalDataDescriptionLanguage.g:1474:4: (lv_subExpression_1_0= ruleLiteralOrReferenceRule )
            {
            // InternalDataDescriptionLanguage.g:1474:4: (lv_subExpression_1_0= ruleLiteralOrReferenceRule )
            // InternalDataDescriptionLanguage.g:1475:5: lv_subExpression_1_0= ruleLiteralOrReferenceRule
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
    // InternalDataDescriptionLanguage.g:1496:1: entryRuleLiteralOrReferenceRule returns [EObject current=null] : iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF ;
    public final EObject entryRuleLiteralOrReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralOrReferenceRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1496:63: (iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF )
            // InternalDataDescriptionLanguage.g:1497:2: iv_ruleLiteralOrReferenceRule= ruleLiteralOrReferenceRule EOF
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
    // InternalDataDescriptionLanguage.g:1503:1: ruleLiteralOrReferenceRule returns [EObject current=null] : (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule ) ;
    public final EObject ruleLiteralOrReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_CallRule_0 = null;

        EObject this_LiteralRule_1 = null;

        EObject this_ParanthesesRule_2 = null;

        EObject this_ValueReferenceRule_3 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1509:2: ( (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule ) )
            // InternalDataDescriptionLanguage.g:1510:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )
            {
            // InternalDataDescriptionLanguage.g:1510:2: (this_CallRule_0= ruleCallRule | this_LiteralRule_1= ruleLiteralRule | this_ParanthesesRule_2= ruleParanthesesRule | this_ValueReferenceRule_3= ruleValueReferenceRule )
            int alt27=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==28) ) {
                    alt27=1;
                }
                else if ( (LA27_1==EOF||LA27_1==17||(LA27_1>=23 && LA27_1<=25)||LA27_1==27||(LA27_1>=29 && LA27_1<=30)||(LA27_1>=42 && LA27_1<=52)) ) {
                    alt27=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case RULE_INT:
            case 31:
            case 32:
                {
                alt27=2;
                }
                break;
            case 28:
                {
                alt27=3;
                }
                break;
            case RULE_QUOTED_ID:
            case 22:
                {
                alt27=4;
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
                    // InternalDataDescriptionLanguage.g:1511:3: this_CallRule_0= ruleCallRule
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
                    // InternalDataDescriptionLanguage.g:1523:3: this_LiteralRule_1= ruleLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1535:3: this_ParanthesesRule_2= ruleParanthesesRule
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
                    // InternalDataDescriptionLanguage.g:1547:3: this_ValueReferenceRule_3= ruleValueReferenceRule
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
    // InternalDataDescriptionLanguage.g:1562:1: entryRuleParanthesesRule returns [EObject current=null] : iv_ruleParanthesesRule= ruleParanthesesRule EOF ;
    public final EObject entryRuleParanthesesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesesRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1562:56: (iv_ruleParanthesesRule= ruleParanthesesRule EOF )
            // InternalDataDescriptionLanguage.g:1563:2: iv_ruleParanthesesRule= ruleParanthesesRule EOF
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
    // InternalDataDescriptionLanguage.g:1569:1: ruleParanthesesRule returns [EObject current=null] : (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) ;
    public final EObject ruleParanthesesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1575:2: ( (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) )
            // InternalDataDescriptionLanguage.g:1576:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            {
            // InternalDataDescriptionLanguage.g:1576:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            // InternalDataDescriptionLanguage.g:1577:3: otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalDataDescriptionLanguage.g:1581:3: ( (lv_subExpression_1_0= ruleExpressionRule ) )
            // InternalDataDescriptionLanguage.g:1582:4: (lv_subExpression_1_0= ruleExpressionRule )
            {
            // InternalDataDescriptionLanguage.g:1582:4: (lv_subExpression_1_0= ruleExpressionRule )
            // InternalDataDescriptionLanguage.g:1583:5: lv_subExpression_1_0= ruleExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_28);
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
    // InternalDataDescriptionLanguage.g:1608:1: entryRuleCallRule returns [EObject current=null] : iv_ruleCallRule= ruleCallRule EOF ;
    public final EObject entryRuleCallRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1608:49: (iv_ruleCallRule= ruleCallRule EOF )
            // InternalDataDescriptionLanguage.g:1609:2: iv_ruleCallRule= ruleCallRule EOF
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
    // InternalDataDescriptionLanguage.g:1615:1: ruleCallRule returns [EObject current=null] : ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) ;
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
            // InternalDataDescriptionLanguage.g:1621:2: ( ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) )
            // InternalDataDescriptionLanguage.g:1622:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            {
            // InternalDataDescriptionLanguage.g:1622:2: ( ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            // InternalDataDescriptionLanguage.g:1623:3: ( (lv_function_0_0= ruleFunctionNameRule ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')'
            {
            // InternalDataDescriptionLanguage.g:1623:3: ( (lv_function_0_0= ruleFunctionNameRule ) )
            // InternalDataDescriptionLanguage.g:1624:4: (lv_function_0_0= ruleFunctionNameRule )
            {
            // InternalDataDescriptionLanguage.g:1624:4: (lv_function_0_0= ruleFunctionNameRule )
            // InternalDataDescriptionLanguage.g:1625:5: lv_function_0_0= ruleFunctionNameRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCallRuleAccess().getFunctionFunctionNameRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_29);
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
              						"de.evoal.languages.model.ddl.dsl.DataDescriptionLanguage.FunctionNameRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalDataDescriptionLanguage.g:1646:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_STRING && LA29_0<=RULE_QUOTED_ID)||LA29_0==22||LA29_0==26||LA29_0==28||(LA29_0>=31 && LA29_0<=32)||(LA29_0>=48 && LA29_0<=49)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1647:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalDataDescriptionLanguage.g:1647:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalDataDescriptionLanguage.g:1648:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalDataDescriptionLanguage.g:1648:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalDataDescriptionLanguage.g:1649:6: lv_parameters_2_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_31);
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

                    // InternalDataDescriptionLanguage.g:1666:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==30) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalDataDescriptionLanguage.g:1667:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,30,FOLLOW_21); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalDataDescriptionLanguage.g:1671:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalDataDescriptionLanguage.g:1672:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalDataDescriptionLanguage.g:1672:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalDataDescriptionLanguage.g:1673:7: lv_parameters_4_0= ruleExpressionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_31);
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
                    	    break loop28;
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


    // $ANTLR start "entryRuleLiteralRule"
    // InternalDataDescriptionLanguage.g:1700:1: entryRuleLiteralRule returns [EObject current=null] : iv_ruleLiteralRule= ruleLiteralRule EOF ;
    public final EObject entryRuleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1700:52: (iv_ruleLiteralRule= ruleLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:1701:2: iv_ruleLiteralRule= ruleLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:1707:1: ruleLiteralRule returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule ) ;
    public final EObject ruleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_StringLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1713:2: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule ) )
            // InternalDataDescriptionLanguage.g:1714:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule )
            {
            // InternalDataDescriptionLanguage.g:1714:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule )
            int alt30=3;
            switch ( input.LA(1) ) {
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
            case 31:
            case 32:
                {
                alt30=3;
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
                    // InternalDataDescriptionLanguage.g:1715:3: this_NumberLiteralRule_0= ruleNumberLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1727:3: this_StringLiteralRule_1= ruleStringLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1739:3: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
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
    // InternalDataDescriptionLanguage.g:1754:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1754:58: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:1755:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:1761:1: ruleNumberLiteralRule returns [EObject current=null] : (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_DoubleLiteralRule_0 = null;

        EObject this_IntegerLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1767:2: ( (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) )
            // InternalDataDescriptionLanguage.g:1768:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            {
            // InternalDataDescriptionLanguage.g:1768:2: (this_DoubleLiteralRule_0= ruleDoubleLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_INT) ) {
                int LA31_1 = input.LA(2);

                if ( (LA31_1==33) ) {
                    alt31=1;
                }
                else if ( (LA31_1==EOF||LA31_1==17||(LA31_1>=23 && LA31_1<=25)||LA31_1==27||(LA31_1>=29 && LA31_1<=30)||(LA31_1>=42 && LA31_1<=52)) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1769:3: this_DoubleLiteralRule_0= ruleDoubleLiteralRule
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
                    // InternalDataDescriptionLanguage.g:1781:3: this_IntegerLiteralRule_1= ruleIntegerLiteralRule
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
    // InternalDataDescriptionLanguage.g:1796:1: entryRuleDoubleLiteralRule returns [EObject current=null] : iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF ;
    public final EObject entryRuleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1796:58: (iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:1797:2: iv_ruleDoubleLiteralRule= ruleDoubleLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:1803:1: ruleDoubleLiteralRule returns [EObject current=null] : ( (lv_value_0_0= ruleDOUBLE ) ) ;
    public final EObject ruleDoubleLiteralRule() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1809:2: ( ( (lv_value_0_0= ruleDOUBLE ) ) )
            // InternalDataDescriptionLanguage.g:1810:2: ( (lv_value_0_0= ruleDOUBLE ) )
            {
            // InternalDataDescriptionLanguage.g:1810:2: ( (lv_value_0_0= ruleDOUBLE ) )
            // InternalDataDescriptionLanguage.g:1811:3: (lv_value_0_0= ruleDOUBLE )
            {
            // InternalDataDescriptionLanguage.g:1811:3: (lv_value_0_0= ruleDOUBLE )
            // InternalDataDescriptionLanguage.g:1812:4: lv_value_0_0= ruleDOUBLE
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
    // InternalDataDescriptionLanguage.g:1832:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1832:59: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:1833:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:1839:1: ruleIntegerLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1845:2: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalDataDescriptionLanguage.g:1846:2: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalDataDescriptionLanguage.g:1846:2: ( (lv_value_0_0= RULE_INT ) )
            // InternalDataDescriptionLanguage.g:1847:3: (lv_value_0_0= RULE_INT )
            {
            // InternalDataDescriptionLanguage.g:1847:3: (lv_value_0_0= RULE_INT )
            // InternalDataDescriptionLanguage.g:1848:4: lv_value_0_0= RULE_INT
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
    // InternalDataDescriptionLanguage.g:1867:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1867:58: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:1868:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:1874:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1880:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalDataDescriptionLanguage.g:1881:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalDataDescriptionLanguage.g:1881:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalDataDescriptionLanguage.g:1882:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalDataDescriptionLanguage.g:1882:3: (lv_value_0_0= RULE_STRING )
            // InternalDataDescriptionLanguage.g:1883:4: lv_value_0_0= RULE_STRING
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
    // InternalDataDescriptionLanguage.g:1902:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // InternalDataDescriptionLanguage.g:1902:59: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // InternalDataDescriptionLanguage.g:1903:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
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
    // InternalDataDescriptionLanguage.g:1909:1: ruleBooleanLiteralRule returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1915:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalDataDescriptionLanguage.g:1916:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalDataDescriptionLanguage.g:1916:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalDataDescriptionLanguage.g:1917:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalDataDescriptionLanguage.g:1917:3: ()
            // InternalDataDescriptionLanguage.g:1918:4: 
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

            // InternalDataDescriptionLanguage.g:1927:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==31) ) {
                alt32=1;
            }
            else if ( (LA32_0==32) ) {
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
                    // InternalDataDescriptionLanguage.g:1928:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalDataDescriptionLanguage.g:1928:4: ( (lv_value_1_0= 'true' ) )
                    // InternalDataDescriptionLanguage.g:1929:5: (lv_value_1_0= 'true' )
                    {
                    // InternalDataDescriptionLanguage.g:1929:5: (lv_value_1_0= 'true' )
                    // InternalDataDescriptionLanguage.g:1930:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
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
                    // InternalDataDescriptionLanguage.g:1943:4: otherlv_2= 'false'
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


    // $ANTLR start "entryRuleStringOrId"
    // InternalDataDescriptionLanguage.g:1952:1: entryRuleStringOrId returns [String current=null] : iv_ruleStringOrId= ruleStringOrId EOF ;
    public final String entryRuleStringOrId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringOrId = null;


        try {
            // InternalDataDescriptionLanguage.g:1952:50: (iv_ruleStringOrId= ruleStringOrId EOF )
            // InternalDataDescriptionLanguage.g:1953:2: iv_ruleStringOrId= ruleStringOrId EOF
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
    // InternalDataDescriptionLanguage.g:1959:1: ruleStringOrId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleStringOrId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_QUOTED_ID_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1965:2: ( (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) )
            // InternalDataDescriptionLanguage.g:1966:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            {
            // InternalDataDescriptionLanguage.g:1966:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_QUOTED_ID) ) {
                alt33=1;
            }
            else if ( (LA33_0==RULE_ID) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:1967:3: this_QUOTED_ID_0= RULE_QUOTED_ID
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
                    // InternalDataDescriptionLanguage.g:1975:3: this_ID_1= RULE_ID
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
    // InternalDataDescriptionLanguage.g:1986:1: entryRuleDOUBLE returns [String current=null] : iv_ruleDOUBLE= ruleDOUBLE EOF ;
    public final String entryRuleDOUBLE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOUBLE = null;


        try {
            // InternalDataDescriptionLanguage.g:1986:46: (iv_ruleDOUBLE= ruleDOUBLE EOF )
            // InternalDataDescriptionLanguage.g:1987:2: iv_ruleDOUBLE= ruleDOUBLE EOF
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
    // InternalDataDescriptionLanguage.g:1993:1: ruleDOUBLE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDOUBLE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:1999:2: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // InternalDataDescriptionLanguage.g:2000:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // InternalDataDescriptionLanguage.g:2000:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // InternalDataDescriptionLanguage.g:2001:3: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_INT_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_INT_0, grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0());
              		
            }
            kw=(Token)match(input,33,FOLLOW_33); if (state.failed) return current;
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


    // $ANTLR start "ruleScaleType"
    // InternalDataDescriptionLanguage.g:2024:1: ruleScaleType returns [Enumerator current=null] : ( (enumLiteral_0= 'nominal' ) | (enumLiteral_1= 'ordinal' ) | (enumLiteral_2= 'cardinal' ) | (enumLiteral_3= 'quotient' ) ) ;
    public final Enumerator ruleScaleType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2030:2: ( ( (enumLiteral_0= 'nominal' ) | (enumLiteral_1= 'ordinal' ) | (enumLiteral_2= 'cardinal' ) | (enumLiteral_3= 'quotient' ) ) )
            // InternalDataDescriptionLanguage.g:2031:2: ( (enumLiteral_0= 'nominal' ) | (enumLiteral_1= 'ordinal' ) | (enumLiteral_2= 'cardinal' ) | (enumLiteral_3= 'quotient' ) )
            {
            // InternalDataDescriptionLanguage.g:2031:2: ( (enumLiteral_0= 'nominal' ) | (enumLiteral_1= 'ordinal' ) | (enumLiteral_2= 'cardinal' ) | (enumLiteral_3= 'quotient' ) )
            int alt34=4;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt34=1;
                }
                break;
            case 35:
                {
                alt34=2;
                }
                break;
            case 36:
                {
                alt34=3;
                }
                break;
            case 37:
                {
                alt34=4;
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
                    // InternalDataDescriptionLanguage.g:2032:3: (enumLiteral_0= 'nominal' )
                    {
                    // InternalDataDescriptionLanguage.g:2032:3: (enumLiteral_0= 'nominal' )
                    // InternalDataDescriptionLanguage.g:2033:4: enumLiteral_0= 'nominal'
                    {
                    enumLiteral_0=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getScaleTypeAccess().getNominalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getScaleTypeAccess().getNominalEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:2040:3: (enumLiteral_1= 'ordinal' )
                    {
                    // InternalDataDescriptionLanguage.g:2040:3: (enumLiteral_1= 'ordinal' )
                    // InternalDataDescriptionLanguage.g:2041:4: enumLiteral_1= 'ordinal'
                    {
                    enumLiteral_1=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getScaleTypeAccess().getOrdinalEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getScaleTypeAccess().getOrdinalEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:2048:3: (enumLiteral_2= 'cardinal' )
                    {
                    // InternalDataDescriptionLanguage.g:2048:3: (enumLiteral_2= 'cardinal' )
                    // InternalDataDescriptionLanguage.g:2049:4: enumLiteral_2= 'cardinal'
                    {
                    enumLiteral_2=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getScaleTypeAccess().getCardinalEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getScaleTypeAccess().getCardinalEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:2056:3: (enumLiteral_3= 'quotient' )
                    {
                    // InternalDataDescriptionLanguage.g:2056:3: (enumLiteral_3= 'quotient' )
                    // InternalDataDescriptionLanguage.g:2057:4: enumLiteral_3= 'quotient'
                    {
                    enumLiteral_3=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2067:1: ruleRepresentationType returns [Enumerator current=null] : ( (enumLiteral_0= 'real' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'string' ) ) ;
    public final Enumerator ruleRepresentationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2073:2: ( ( (enumLiteral_0= 'real' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'string' ) ) )
            // InternalDataDescriptionLanguage.g:2074:2: ( (enumLiteral_0= 'real' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'string' ) )
            {
            // InternalDataDescriptionLanguage.g:2074:2: ( (enumLiteral_0= 'real' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'string' ) )
            int alt35=4;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt35=1;
                }
                break;
            case 39:
                {
                alt35=2;
                }
                break;
            case 40:
                {
                alt35=3;
                }
                break;
            case 41:
                {
                alt35=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2075:3: (enumLiteral_0= 'real' )
                    {
                    // InternalDataDescriptionLanguage.g:2075:3: (enumLiteral_0= 'real' )
                    // InternalDataDescriptionLanguage.g:2076:4: enumLiteral_0= 'real'
                    {
                    enumLiteral_0=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRepresentationTypeAccess().getRealEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRepresentationTypeAccess().getRealEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:2083:3: (enumLiteral_1= 'integer' )
                    {
                    // InternalDataDescriptionLanguage.g:2083:3: (enumLiteral_1= 'integer' )
                    // InternalDataDescriptionLanguage.g:2084:4: enumLiteral_1= 'integer'
                    {
                    enumLiteral_1=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRepresentationTypeAccess().getIntegerEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRepresentationTypeAccess().getIntegerEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:2091:3: (enumLiteral_2= 'boolean' )
                    {
                    // InternalDataDescriptionLanguage.g:2091:3: (enumLiteral_2= 'boolean' )
                    // InternalDataDescriptionLanguage.g:2092:4: enumLiteral_2= 'boolean'
                    {
                    enumLiteral_2=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRepresentationTypeAccess().getBooleanEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getRepresentationTypeAccess().getBooleanEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:2099:3: (enumLiteral_3= 'string' )
                    {
                    // InternalDataDescriptionLanguage.g:2099:3: (enumLiteral_3= 'string' )
                    // InternalDataDescriptionLanguage.g:2100:4: enumLiteral_3= 'string'
                    {
                    enumLiteral_3=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2110:1: ruleComparisonOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) ;
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
            // InternalDataDescriptionLanguage.g:2116:2: ( ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) )
            // InternalDataDescriptionLanguage.g:2117:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalDataDescriptionLanguage.g:2117:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            int alt36=6;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt36=1;
                }
                break;
            case 43:
                {
                alt36=2;
                }
                break;
            case 44:
                {
                alt36=3;
                }
                break;
            case 45:
                {
                alt36=4;
                }
                break;
            case 46:
                {
                alt36=5;
                }
                break;
            case 47:
                {
                alt36=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalDataDescriptionLanguage.g:2118:3: (enumLiteral_0= '>=' )
                    {
                    // InternalDataDescriptionLanguage.g:2118:3: (enumLiteral_0= '>=' )
                    // InternalDataDescriptionLanguage.g:2119:4: enumLiteral_0= '>='
                    {
                    enumLiteral_0=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:2126:3: (enumLiteral_1= '>' )
                    {
                    // InternalDataDescriptionLanguage.g:2126:3: (enumLiteral_1= '>' )
                    // InternalDataDescriptionLanguage.g:2127:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:2134:3: (enumLiteral_2= '=' )
                    {
                    // InternalDataDescriptionLanguage.g:2134:3: (enumLiteral_2= '=' )
                    // InternalDataDescriptionLanguage.g:2135:4: enumLiteral_2= '='
                    {
                    enumLiteral_2=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDescriptionLanguage.g:2142:3: (enumLiteral_3= '!=' )
                    {
                    // InternalDataDescriptionLanguage.g:2142:3: (enumLiteral_3= '!=' )
                    // InternalDataDescriptionLanguage.g:2143:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalDataDescriptionLanguage.g:2150:3: (enumLiteral_4= '<' )
                    {
                    // InternalDataDescriptionLanguage.g:2150:3: (enumLiteral_4= '<' )
                    // InternalDataDescriptionLanguage.g:2151:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalDataDescriptionLanguage.g:2158:3: (enumLiteral_5= '<=' )
                    {
                    // InternalDataDescriptionLanguage.g:2158:3: (enumLiteral_5= '<=' )
                    // InternalDataDescriptionLanguage.g:2159:4: enumLiteral_5= '<='
                    {
                    enumLiteral_5=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2169:1: ruleAddOrSubtractOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOrSubtractOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2175:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalDataDescriptionLanguage.g:2176:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalDataDescriptionLanguage.g:2176:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==48) ) {
                alt37=1;
            }
            else if ( (LA37_0==49) ) {
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
                    // InternalDataDescriptionLanguage.g:2177:3: (enumLiteral_0= '+' )
                    {
                    // InternalDataDescriptionLanguage.g:2177:3: (enumLiteral_0= '+' )
                    // InternalDataDescriptionLanguage.g:2178:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:2185:3: (enumLiteral_1= '-' )
                    {
                    // InternalDataDescriptionLanguage.g:2185:3: (enumLiteral_1= '-' )
                    // InternalDataDescriptionLanguage.g:2186:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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
    // InternalDataDescriptionLanguage.g:2196:1: ruleMultiplyDivideModuloOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalDataDescriptionLanguage.g:2202:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalDataDescriptionLanguage.g:2203:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalDataDescriptionLanguage.g:2203:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt38=3;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt38=1;
                }
                break;
            case 51:
                {
                alt38=2;
                }
                break;
            case 52:
                {
                alt38=3;
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
                    // InternalDataDescriptionLanguage.g:2204:3: (enumLiteral_0= '*' )
                    {
                    // InternalDataDescriptionLanguage.g:2204:3: (enumLiteral_0= '*' )
                    // InternalDataDescriptionLanguage.g:2205:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDescriptionLanguage.g:2212:3: (enumLiteral_1= '/' )
                    {
                    // InternalDataDescriptionLanguage.g:2212:3: (enumLiteral_1= '/' )
                    // InternalDataDescriptionLanguage.g:2213:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDescriptionLanguage.g:2220:3: (enumLiteral_2= '%' )
                    {
                    // InternalDataDescriptionLanguage.g:2220:3: (enumLiteral_2= '%' )
                    // InternalDataDescriptionLanguage.g:2221:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
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


    protected DFA11 dfa11 = new DFA11(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\42\4\16\1\uffff\1\5\2\21\1\uffff";
    static final String dfa_3s = "\1\51\4\16\1\uffff\1\7\2\25\1\uffff";
    static final String dfa_4s = "\5\uffff\1\2\3\uffff\1\1";
    static final String dfa_5s = "\12\uffff}>";
    static final String[] dfa_6s = {
            "\4\5\1\1\1\2\1\3\1\4",
            "\1\6",
            "\1\6",
            "\1\6",
            "\1\6",
            "",
            "\1\10\1\uffff\1\7",
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
            return "392:2: (this_TypedDataDescriptionRule_0= ruleTypedDataDescriptionRule | this_UntypedDataDescriptionRule_1= ruleUntypedDataDescriptionRule )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000001D002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000003C0000C002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000003FC00008002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00030001944000F2L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000001A0000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00030001944200F0L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000003C000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00030001944000F0L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000FC0000000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x001C000000000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x00030001B44000F0L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000040L});

}